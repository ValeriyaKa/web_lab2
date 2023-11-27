import java.io.Serializable;

public final class ResultRow implements Serializable {
    private Float x;
    private Float y;
    private Float r;
    private String value;
    private String execTime;
    private String time;

    public ResultRow(Float x, Float y, Float r, String execTime, String value, String currentTime) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.execTime = execTime;
        this.value = value;
        this.time = currentTime;
    }


    public Float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Float getR() {
        return r;
    }
    public String getValue(){return value;}
    public String getExecTime(){return execTime; }


    public void setHit(String value) {
        this.value = value;
    }

    public void setExecTime(String execTime) {
        this.execTime = execTime;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getTime(){return time;}

}
