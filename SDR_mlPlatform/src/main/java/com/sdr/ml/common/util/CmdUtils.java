package com.sdr.ml.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.portlet.PortletProps;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

public class CmdUtils {

    /**
     * @Methods Name : byCommonsExec
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : commond 명령 실행
     */
    public static String byCommonsExec(String[] defaultCommand, String[] addArgument) throws IOException {

        DefaultExecutor executor = new DefaultExecutor();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

        executor.setStreamHandler(streamHandler);

        log.debug(">>>" + defaultCommand);
        CommandLine cmdLine = CommandLine.parse(defaultCommand[0]);

        // 기본 커멘드
        for (int i = 1, n = defaultCommand.length; i < n; i++) {
            cmdLine.addArgument(defaultCommand[i]);
        }

        // 추가 아귀먼트가 비어있지 않으면
        if ( addArgument != null && addArgument.length > 0  ) {
            for (int i = 0, n = addArgument.length; i < n; i++) {
                cmdLine.addArgument(addArgument[i]);
            }
        }

        try {
            log.debug("##### byCommonsExec : " + cmdLine);
            executor.execute(cmdLine);
        } catch (ExecuteException ee) {
            log.error(ee.getMessage());
        }

        return outputStream.toString();
    }


    /**
     * @Methods Name : objectEmptyCheck
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Object type 변수가 비어있는지 체크
     */
    public static Boolean objectEmptyCheck(Object obj) {
        if (obj instanceof String)
            return obj == null || "".equals(obj.toString().trim());
        else if (obj instanceof List)
            return obj == null || ((List) obj).isEmpty();
        else if (obj instanceof Map)
            return obj == null || ((Map) obj).isEmpty();
        else if (obj instanceof Object[])
            return obj == null || Array.getLength(obj) == 0;
        else
            return obj == null;
    }


    /**
     * @Methods Name : getPythonCommand
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 파이썬 실행기 이름 프로퍼티에서 가져오기
     */
    protected static String getPythonCommand() {
        String pythonCommand = null;
        try {
            pythonCommand = PortletProps.get("pythonCommand");
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return pythonCommand;
    }


    private static Log log = LogFactoryUtil.getLog(CmdUtils.class);
}
