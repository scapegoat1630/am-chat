package com.am.chat.model;

import java.io.Serializable;

public class Permission implements Serializable {
    /**
     *  ,所属表字段为am_permission.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *  ,所属表字段为am_permission.role_id
     *
     * @mbggenerated
     */
    private Integer roleId;

    /**
     *  ,所属表字段为am_permission.dataDomain
     *
     * @mbggenerated
     */
    private String datadomain;

    /**
     *  ,所属表字段为am_permission.dataType
     *
     * @mbggenerated
     */
    private String datatype;

    /**
     *  ,所属表字段为am_permission.operation
     *
     * @mbggenerated
     */
    private String operation;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getDatadomain() {
        return datadomain;
    }

    public void setDatadomain(String datadomain) {
        this.datadomain = datadomain;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Permission other = (Permission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getDatadomain() == null ? other.getDatadomain() == null : this.getDatadomain().equals(other.getDatadomain()))
            && (this.getDatatype() == null ? other.getDatatype() == null : this.getDatatype().equals(other.getDatatype()))
            && (this.getOperation() == null ? other.getOperation() == null : this.getOperation().equals(other.getOperation()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getDatadomain() == null) ? 0 : getDatadomain().hashCode());
        result = prime * result + ((getDatatype() == null) ? 0 : getDatatype().hashCode());
        result = prime * result + ((getOperation() == null) ? 0 : getOperation().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", datadomain=").append(datadomain);
        sb.append(", datatype=").append(datatype);
        sb.append(", operation=").append(operation);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
    public  String getPermessionString(){
        return   getDatatype() + ":" + getOperation() + (getDatadomain() == null || getDatadomain()
                .equals("") ? "" : (":" + getDatadomain()));
    }

}