package class5.summarySeleniumExe.Infra;

import lombok.Data;

import java.util.Map;
@Data
public class ResponseWrapper<T> {
    private int status;
    private Map<String, String> responseHeaders;
    private T data;

    public ResponseWrapper() {
    }
}
