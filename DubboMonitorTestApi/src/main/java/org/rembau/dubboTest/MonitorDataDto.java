package org.rembau.dubboTest;

import java.util.Date;

/**
 * Created by rembau on 2017/2/24.
 */
public class MonitorDataDto {
    private String protocol;
    private String userName;
    private String password;
    private String host;
    private int port;
    private String path;
    private String method;
    private String concurrent;
    private String interfaceStr;
    private String elapsed;
    private String output;
    private String maxConcurrent;
    private String input;
    private String application;
    private String provider;
    private String consumer;
    private String success;
    private String failure;
    private String maxElapsed;
    private String maxInput;
    private String maxOutput;
    private String timestamp;
    private Date date;

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getConcurrent() {
        return concurrent;
    }

    public void setConcurrent(String concurrent) {
        this.concurrent = concurrent;
    }

    public String getInterfaceStr() {
        return interfaceStr;
    }

    public void setInterfaceStr(String interfaceStr) {
        this.interfaceStr = interfaceStr;
    }

    public String getElapsed() {
        return elapsed;
    }

    public void setElapsed(String elapsed) {
        this.elapsed = elapsed;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getMaxConcurrent() {
        return maxConcurrent;
    }

    public void setMaxConcurrent(String maxConcurrent) {
        this.maxConcurrent = maxConcurrent;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getFailure() {
        return failure;
    }

    public void setFailure(String failure) {
        this.failure = failure;
    }

    public String getMaxElapsed() {
        return maxElapsed;
    }

    public void setMaxElapsed(String maxElapsed) {
        this.maxElapsed = maxElapsed;
    }

    public String getMaxInput() {
        return maxInput;
    }

    public void setMaxInput(String maxInput) {
        this.maxInput = maxInput;
    }

    public String getMaxOutput() {
        return maxOutput;
    }

    public void setMaxOutput(String maxOutput) {
        this.maxOutput = maxOutput;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
