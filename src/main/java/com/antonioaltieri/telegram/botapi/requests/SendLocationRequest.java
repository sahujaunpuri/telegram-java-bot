package com.antonioaltieri.telegram.botapi.requests;

import com.antonioaltieri.telegram.botapi.types.Message;

import java.util.HashMap;
import java.util.Map;

public class SendLocationRequest implements ApiRequest<Message> {

    private Map<String, String> args = new HashMap<>();

    public SendLocationRequest(long chatId, float latitude, float longitude) {
        this(chatId, latitude, longitude, null);
    }

    public SendLocationRequest(long chatId, float latitude, float longitude, OptionalArgs optionalArgs) {
        args.put("chat_id", String.valueOf(chatId));
        args.put("latitude", String.valueOf(latitude));
        args.put("longitude", String.valueOf(longitude));

        if (optionalArgs != null)
            args.putAll(optionalArgs.options());
    }

    @Override
    public String getMethodName() {
        return "sendLocation";
    }

    @Override
    public ResultTypes getResultType() {
        return ResultTypes.MESSAGE;
    }

    @Override
    public Map<String, String> getArgs() {
        return args;
    }

    @Override
    public RequestStrategy getRequestStrategy() {
        return new PostStrategy();
    }

    @Override
    public String toString() {
        return "SendLocationRequest{" +
                "args=" + args +
                '}';
    }
}
