package xmlUtil.model;

import xmlUtil.annotation.AliasName;

public class Xml {

    private String appid;

    @AliasName(value = "one")
    private String url;

    @AliasName(value = "two",isData = true)
    private String body;

    private String sign;

    private String attch;

    public Xml(String appid, String url, String body, String sign, String attch) {
        this.appid = appid;
        this.url = url;
        this.body = body;
        this.sign = sign;
        this.attch = attch;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAttch() {
        return attch;
    }

    public void setAttch(String attch) {
        this.attch = attch;
    }
}
