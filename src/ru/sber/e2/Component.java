/**
Component имеет id (Integer), name, status (Boolean).
Status true означает что компонент работает исправно, а false – что компонент сломан.
 */
package ru.sber.e2;

public class Component {

    private Integer id;

    private String name;

    private Boolean status;

    public Component(Integer id, String name, Boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
