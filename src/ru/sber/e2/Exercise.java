/**
Имеется набор устройств Device. Каждый device имеет id (Integer), name (String),
набор компонентов Component и status (для статуса устройства предусмотрено три значения: normal, warning, error).

Component имеет id (Integer), name, status (Boolean).
Status true означает что компонент работает исправно, а false – что компонент сломан.

Нужно хранить в какой-либо структуре данных набор всех устройств (Device) системы,
должна быть возможность получить все данные об устройстве по его Id.

В систему на вход поступает набор событий Event. События могут быть разных типов ErrorEvent, RestoreEvent.

ErrorEvent содержит поля:
Integer deviceId
Integer componentId

RestoreEvent содержит поля:
Integer deviceId
Integer componentId

Считать, что на вход подается очередь сообщений Event.
Программа обрабатывает каждое сообщение из этой очереди последовательно.
Событие ErrorEvent говорит о том что компонент componentId у устройства deviceId сломался.
Событие RestoreEvent говорит о том что компонент componentId у устройства deviceId восстановил свою работу.

Если все компоненты устройства работают, устройство в статусе Normal.
Если хотя бы одна компонента устройства не работает, устройство в статусе Warning.
Если более половины компонент устройства не работает, устройство в статусе Error.

При изменении состояния устройства (Device) нужно написать в лог следующее
“Устройство id = ?, name = ? изменило свое состояние на ?”.
*/
package ru.sber.e2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Exercise {

    final static Logger logger = LoggerFactory.getLogger(Exercise.class);

    public static void main(String[] args) {
        Device printer = new Device(1, "printer");
        Device scanner = new Device(2, "scanner");
        List<Device> devices = new ArrayList<>();
        devices.add(printer);
        devices.add(scanner);

        Queue<Event> eventQueue = new LinkedList<>();
        eventQueue.add(new ErrorEvent(1, 1));
        eventQueue.add(new ErrorEvent(1, 2));
        eventQueue.add(new ErrorEvent(1, 3));
        eventQueue.add(new ErrorEvent(2, 1));
//        System.out.println(eventQueue.element().getClass().equals(ErrorEvent.class));

        updateComponentsStatus(devices, eventQueue);
        updateDeviceStatus(devices);
    }

    private static void updateDeviceStatus(List<Device> devices) {
        for (Device device : devices) {
            int errorCount = 0;
            for (int i = 1; i < device.componentsCount(); i++) {
                if (device.getComponentById(i).getStatus() == false) {
                    errorCount += 1;
                }
            }
            if (errorCount == 0) {
                device.setStatus(Status.NORMAL);
                logger.info("Устройство id = {}, name = {} изменило свое состояние на {}\n",
                        device.getId(), device.getName(), device.getStatus());
            } else if (errorCount == 1) {
                device.setStatus(Status.WARNING);
                logger.info("Устройство id = {}, name = {} изменило свое состояние на {}\n",
                        device.getId(), device.getName(), device.getStatus());
            } else {
                device.setStatus(Status.ERROR);
                logger.info("Устройство id = {}, name = {} изменило свое состояние на {}\n",
                        device.getId(), device.getName(), device.getStatus());
            }
        }
    }

    private static void updateComponentsStatus(List<Device> devices, Queue<Event> eventQueue) {
        do {
            Event event = eventQueue.poll();
            for (Device device : devices) {
                if (event instanceof ErrorEvent) {
                    if (event.getDeviceId() == device.getId()) {
                        Integer eventComponentId = event.getComponentId();
                        Component component = device.getComponentById(eventComponentId);
                        component.setStatus(false);
                    }
                }
                if (event instanceof RestoreEvent) {
                    if (event.getDeviceId() == device.getId()) {
                        Integer eventComponentId = event.getComponentId();
                        Component component = device.getComponentById(eventComponentId);
                        component.setStatus(true);
                    }
                }
            }
        } while (!eventQueue.isEmpty());
    }

}
