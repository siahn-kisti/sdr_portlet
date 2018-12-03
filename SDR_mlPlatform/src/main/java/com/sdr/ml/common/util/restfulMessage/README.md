```java
        RestMessageCallbackEvent restMessageCallbackEvent = new RestMessageCallbackEvent(){

            @Override
            public void executeMethod(ResourceRequest request, ResourceResponse response, RestMessageVo restMessageVo) {
                /*
                 * TODO: 처리할 작업 내용 작성 후 restMessageVo에 알맞게 작성
                */
                
                restMessageVo.setCode(MlStringUtils._CODE_CURATION_SUCCESS);
                restMessageVo.setCodeDescription(MlStringUtils._MSG_CURATION_SUCCESS);
                // 생략 가능
                restMessageVo.setData("Json String");
            }

            @Override
            public void responseMethod(RestMessageVo restMessageVo) {
                _log.debug(String.format("%s(%s): %s", restMessageVo.getCode(), restMessageVo.getCodeDescription(), restMessageVo.getData()));
            }

            @Override
            public void errorMethod(RestMessageVo restMessageVo) {
                _log.debug(String.format("%s(%s)", restMessageVo.getCode(), restMessageVo.getCodeDescription()));
            }
        };

        RestMessageEventRegistration restMessageEventRegistration = new RestMessageEventRegistration(request, response, restMessageCallbackEvent);
        restMessageEventRegistration.doWork();
```