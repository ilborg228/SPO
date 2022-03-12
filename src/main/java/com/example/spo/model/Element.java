package com.example.spo.model;

public interface Element {

    /**
     * @return first field
     */
    Object getFirstField();
    /**
     * @return second field
     */
    Object getSecondField();
    /**
     * @return third field
     */
    Object getThirdField();

    /**
     * Set first field value
     * @param e first field new value
     */
    void setFirstField(Object e);

    /**
     * Set second field value
     * @param e second field new value
     */
    void setSecondField(Object e);

    /**
     * Set third field value
     * @param e third field new value
     */
    void setThirdField(Object e);
}
