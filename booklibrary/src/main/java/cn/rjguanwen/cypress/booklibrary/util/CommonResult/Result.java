package cn.rjguanwen.cypress.booklibrary.util.CommonResult;

/**
 * @ClassName: Result
 * @Description: TODO
 * @Author: 郑斌
 * @Date: 2019/5/13 14:02
 **/
public class Result {
    // 状态码
    private String code;
    // 文本信息
    private String msg;
    // 返回数据
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 构造函数
     * @param code
     */
    public Result (String code){
        this.code = code;
    }

    /**
     * 构造函数
     * @param code
     */
    public Result (String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 构造函数
     * @param code
     * @param data
     */
    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
