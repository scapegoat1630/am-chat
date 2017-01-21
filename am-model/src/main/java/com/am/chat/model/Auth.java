package com.am.chat.model;

import java.io.Serializable;

public class Auth implements Serializable {
    /**
     *  ,所属表字段为am_authc_map.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *  ,所属表字段为am_authc_map.authcType
     *
     * @mbggenerated
     */
    private String authctype;

    /**
     *  ,所属表字段为am_authc_map.url
     *
     * @mbggenerated
     */
    private String url;

    /**
     *  ,所属表字段为am_authc_map.val
     *
     * @mbggenerated
     */
    private String val;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthctype() {
        return authctype;
    }

    public void setAuthctype(String authctype) {
        this.authctype = authctype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
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
        Auth other = (Auth) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAuthctype() == null ? other.getAuthctype() == null : this.getAuthctype().equals(other.getAuthctype()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getVal() == null ? other.getVal() == null : this.getVal().equals(other.getVal()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAuthctype() == null) ? 0 : getAuthctype().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getVal() == null) ? 0 : getVal().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", authctype=").append(authctype);
        sb.append(", url=").append(url);
        sb.append(", val=").append(val);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}