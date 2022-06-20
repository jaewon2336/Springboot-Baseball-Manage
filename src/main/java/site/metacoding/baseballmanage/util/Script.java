package site.metacoding.baseballmanage.util;

public class Script {
    // 오버로딩 (메세지 안띄우고싶을때)
    public static String href(String url, String msg) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("alert('" + msg + "');");
        sb.append("location.href = '" + url + "';");
        sb.append("</script>");

        return sb.toString();
    }

    public static String href(String url) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("location.href = '" + url + "';");
        sb.append("</script>");

        return sb.toString();
    }

    public static String back(String msg) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("alert('" + msg + "');");
        sb.append("history.back();");
        sb.append("</script>");

        return sb.toString();
    }
}