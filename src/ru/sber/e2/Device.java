package ru.sber.e2;

public class Device {

    private Integer id;

    private String name;

    private Component[] components;

    private Status status;

    public Device(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.components = new Component[] {
                new Component(1, "component1", true),
                new Component(2, "component2", true),
                new Component(3, "component3", true)
        };
        this.status = status.NORMAL;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Component getComponentById(Integer id) {
        return components[id - 1];
    }

    public Integer componentsCount() {
        return components.length;
    }

}
