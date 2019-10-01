package ru.sber.e2;

public class RestoreEvent implements Event {

    private Integer deviceId;

    private Integer componentId;

    public RestoreEvent(Integer deviceId, Integer componentId) {
        this.deviceId = deviceId;
        this.componentId = componentId;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    @Override
    public Integer getComponentId() {
        return componentId;
    }

}
