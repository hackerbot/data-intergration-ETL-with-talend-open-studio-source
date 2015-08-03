package org.talend.designer.codegen.translators.esb.webservices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.codegen.config.NodeConnectionsHelper;
import org.talend.designer.codegen.config.NodeParamsHelper;

public class TESBConsumerMainJava
{
  protected static String nl;
  public static synchronized TESBConsumerMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TESBConsumerMainJava result = new TESBConsumerMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "        ";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + "    final javax.xml.namespace.QName serviceName_";
  protected final String TEXT_4 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_5 = "\", \"";
  protected final String TEXT_6 = "\");" + NL + "    final javax.xml.namespace.QName portName_";
  protected final String TEXT_7 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_8 = "\", \"";
  protected final String TEXT_9 = "\");" + NL + "" + NL + "    try {" + NL + "        routines.system.Document requestTalendDoc_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".payload;" + NL + "" + NL + "        try {" + NL + "            org.dom4j.Document responseDoc_";
  protected final String TEXT_12 = " = null;" + NL;
  protected final String TEXT_13 = NL + "                final java.util.Map<String, String> slCustomProps_";
  protected final String TEXT_14 = " = new java.util.HashMap<String, String>();";
  protected final String TEXT_15 = "slCustomProps_";
  protected final String TEXT_16 = ".put(";
  protected final String TEXT_17 = ", ";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + NL + "            java.util.Map<String, String> customProps_";
  protected final String TEXT_20 = " = null;";
  protected final String TEXT_21 = NL + "                    customProps_";
  protected final String TEXT_22 = " = new java.util.HashMap<String, String>();";
  protected final String TEXT_23 = NL + "                    customProps_";
  protected final String TEXT_24 = ".put(";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "                class EsbJobCorrelationCallbackHandler implements org.talend.esb.policy.correlation.CorrelationIDCallbackHandler {" + NL + "                    private String correlationId;" + NL + "                    public EsbJobCorrelationCallbackHandler(final String correlationId) {" + NL + "                        if (null != correlationId && correlationId.length() > 0) {" + NL + "                            this.correlationId = correlationId;" + NL + "                        }" + NL + "                    }" + NL + "                    public String getCorrelationId() {" + NL + "                        return correlationId;" + NL + "                    };" + NL + "                }" + NL + "                final Object correlationIDCallbackHandler = new EsbJobCorrelationCallbackHandler(";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + NL + "            final List<org.apache.cxf.headers.Header> soapHeaders_";
  protected final String TEXT_30 = " = new java.util.ArrayList<org.apache.cxf.headers.Header>();";
  protected final String TEXT_31 = NL + "                final Object securityToken_";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "                    securityToken_";
  protected final String TEXT_34 = " = globalMap.get(\"";
  protected final String TEXT_35 = "_SECURITY_TOKEN\");";
  protected final String TEXT_36 = NL + "                final routines.system.Document headersTalendDoc_";
  protected final String TEXT_37 = " = ";
  protected final String TEXT_38 = ".headers;" + NL + "                if (null != headersTalendDoc_";
  protected final String TEXT_39 = " && null != headersTalendDoc_";
  protected final String TEXT_40 = ".getDocument()) {" + NL + "                    javax.xml.transform.dom.DOMResult result = new javax.xml.transform.dom.DOMResult();" + NL + "                    javax.xml.transform.TransformerFactory.newInstance().newTransformer().transform(new org.dom4j.io.DocumentSource(headersTalendDoc_";
  protected final String TEXT_41 = ".getDocument()), result);" + NL + "                    for (org.w3c.dom.Node node = ((org.w3c.dom.Document) result.getNode()).getDocumentElement().getFirstChild();" + NL + "                            node != null;" + NL + "                            node = node.getNextSibling()) {" + NL + "                        if (org.w3c.dom.Node.ELEMENT_NODE == node.getNodeType()) {" + NL + "                            soapHeaders_";
  protected final String TEXT_42 = ".add(new org.apache.cxf.headers.Header(new javax.xml.namespace.QName(node.getNamespaceURI(), node.getLocalName()), node));" + NL + "                        }" + NL + "                    }" + NL + "                }";
  protected final String TEXT_43 = NL + NL + "            if (null == ";
  protected final String TEXT_44 = ".this.registry) {" + NL + "                GenericConsumer genericConsumer_";
  protected final String TEXT_45 = " = new GenericConsumer();" + NL + "                genericConsumer_";
  protected final String TEXT_46 = ".setServiceQName(serviceName_";
  protected final String TEXT_47 = ");" + NL + "                genericConsumer_";
  protected final String TEXT_48 = ".setPortQName(portName_";
  protected final String TEXT_49 = ");" + NL + "                genericConsumer_";
  protected final String TEXT_50 = ".setOperationQName(new javax.xml.namespace.QName(\"";
  protected final String TEXT_51 = "\", \"";
  protected final String TEXT_52 = "\"));" + NL + "                genericConsumer_";
  protected final String TEXT_53 = ".setIsRequestResponse(";
  protected final String TEXT_54 = ");";
  protected final String TEXT_55 = NL + "                        genericConsumer_";
  protected final String TEXT_56 = ".setSoapAction(\"";
  protected final String TEXT_57 = "\");";
  protected final String TEXT_58 = NL + NL + "                genericConsumer_";
  protected final String TEXT_59 = ".setAddress(";
  protected final String TEXT_60 = ");" + NL + "                if (null != getClass().getResourceAsStream(\"wsdl/";
  protected final String TEXT_61 = ".wsdl\")) {" + NL + "                    genericConsumer_";
  protected final String TEXT_62 = ".setWsdlURL(\"classpath:/\" + this.getClass().getPackage().getName().replace(\".\", \"/\") + \"/wsdl/";
  protected final String TEXT_63 = ".wsdl\");" + NL + "                }" + NL + "" + NL + "                java.util.Collection<org.apache.cxf.feature.Feature> esbFeatures_";
  protected final String TEXT_64 = " =" + NL + "                        new java.util.ArrayList<org.apache.cxf.feature.Feature>();" + NL;
  protected final String TEXT_65 = NL + "                    genericConsumer_";
  protected final String TEXT_66 = ".setAddress(\"locator://\");" + NL + "" + NL + "                    // if (!inOSGi) {" + NL + "                    genericConsumer_";
  protected final String TEXT_67 = ".setBus(new org.apache.cxf.bus.spring.SpringBusFactory().createBus(\"META-INF/tesb/locator/beans.xml\"));" + NL + "                    // }" + NL + "                    org.talend.esb.servicelocator.cxf.LocatorFeature featureSL_";
  protected final String TEXT_68 = " = new org.talend.esb.servicelocator.cxf.LocatorFeature();" + NL + "                    if (null != slCustomProps_";
  protected final String TEXT_69 = " && !slCustomProps_";
  protected final String TEXT_70 = ".isEmpty()) {" + NL + "                        featureSL_";
  protected final String TEXT_71 = ".setRequiredEndpointProperties(slCustomProps_";
  protected final String TEXT_72 = ");" + NL + "                    }" + NL + "                    esbFeatures_";
  protected final String TEXT_73 = ".add(featureSL_";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = NL + "                    // if (null == eventFeature) {" + NL + "                    org.springframework.context.support.ClassPathXmlApplicationContext classpathXmlApplicationContext =" + NL + "                            new org.springframework.context.support.ClassPathXmlApplicationContext(\"META-INF/tesb/agent-context.xml\");" + NL + "                    org.talend.esb.sam.agent.feature.EventFeature featureSAM_";
  protected final String TEXT_76 = " = classpathXmlApplicationContext.getBean(org.talend.esb.sam.agent.feature.EventFeature.class);" + NL + "                    // }" + NL + "                    if (null != customProps_";
  protected final String TEXT_77 = " && !customProps_";
  protected final String TEXT_78 = ".isEmpty()) {" + NL + "                        org.talend.esb.sam.common.handler.impl.CustomInfoHandler ciHandler = new org.talend.esb.sam.common.handler.impl.CustomInfoHandler();" + NL + "                        ciHandler.setCustomInfo(customProps_";
  protected final String TEXT_79 = ");" + NL + "                        featureSAM_";
  protected final String TEXT_80 = ".setHandler(ciHandler);" + NL + "                    }" + NL + "                    esbFeatures_";
  protected final String TEXT_81 = ".add(featureSAM_";
  protected final String TEXT_82 = ");";
  protected final String TEXT_83 = NL + "                    esbFeatures_";
  protected final String TEXT_84 = ".add(new org.talend.esb.policy.correlation.feature.CorrelationIDFeature());";
  protected final String TEXT_85 = NL + "                    genericConsumer_";
  protected final String TEXT_86 = ".setCorrelationIDCallbackHandler(correlationIDCallbackHandler);";
  protected final String TEXT_87 = NL + "                genericConsumer_";
  protected final String TEXT_88 = ".setEsbFeatures(esbFeatures_";
  protected final String TEXT_89 = ");" + NL + "\t\t\t\tboolean use_auth_";
  protected final String TEXT_90 = " = false;" + NL + "\t\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\t   use_auth_";
  protected final String TEXT_92 = " = ";
  protected final String TEXT_93 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_94 = NL + "\t\t\t\t   use_auth_";
  protected final String TEXT_95 = " = true; // not from context" + NL + "\t\t\t\t";
  protected final String TEXT_96 = NL + "    \t\t\tif (use_auth_";
  protected final String TEXT_97 = ") {" + NL + "\t\t\t\t   ";
  protected final String TEXT_98 = NL + "                    genericConsumer_";
  protected final String TEXT_99 = ".setAuthType(";
  protected final String TEXT_100 = ");" + NL + "\t\t\t\t   ";
  protected final String TEXT_101 = NL + "                    genericConsumer_";
  protected final String TEXT_102 = ".setAuthType(\"";
  protected final String TEXT_103 = "\");" + NL + "\t\t\t\t   ";
  protected final String TEXT_104 = NL + "                    genericConsumer_";
  protected final String TEXT_105 = ".setUsername(";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_108 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_111 = " = ";
  protected final String TEXT_112 = "; ";
  protected final String TEXT_113 = NL + "                       " + NL + "                    genericConsumer_";
  protected final String TEXT_114 = ".setPassword(decryptedPassword_";
  protected final String TEXT_115 = ");" + NL + "\t\t\t\t}" + NL + "" + NL + " \t\t\t\tboolean use_proxy_";
  protected final String TEXT_116 = " = false;" + NL + "\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\t   use_proxy_";
  protected final String TEXT_118 = " = ";
  protected final String TEXT_119 = ";" + NL + "\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\t   use_proxy_";
  protected final String TEXT_121 = " = true; // not from context" + NL + "\t\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\tif (use_proxy_";
  protected final String TEXT_123 = "){" + NL + "                    genericConsumer_";
  protected final String TEXT_124 = ".setProxyServer(";
  protected final String TEXT_125 = ");" + NL + "                    genericConsumer_";
  protected final String TEXT_126 = ".setProxyPort(";
  protected final String TEXT_127 = ");" + NL + "                    genericConsumer_";
  protected final String TEXT_128 = ".setProxyUsername(";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_131 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_132 = ");";
  protected final String TEXT_133 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_134 = " = ";
  protected final String TEXT_135 = "; ";
  protected final String TEXT_136 = NL + "                       " + NL + "                    genericConsumer_";
  protected final String TEXT_137 = ".setProxyPassword(decryptedPassword_";
  protected final String TEXT_138 = ");" + NL + "\t\t\t\t}" + NL + "" + NL + "                genericConsumer_";
  protected final String TEXT_139 = ".setConnectionTimeout((long)(";
  protected final String TEXT_140 = " * 1000L));" + NL + "                genericConsumer_";
  protected final String TEXT_141 = ".setReceiveTimeout((long)(";
  protected final String TEXT_142 = " * 1000L));" + NL + "                genericConsumer_";
  protected final String TEXT_143 = ".setAutoRedirect(";
  protected final String TEXT_144 = ");" + NL + "                genericConsumer_";
  protected final String TEXT_145 = ".setRedirectSameHostOnly(";
  protected final String TEXT_146 = ");" + NL + "" + NL + "                genericConsumer_";
  protected final String TEXT_147 = ".setLogMessages(";
  protected final String TEXT_148 = ");" + NL;
  protected final String TEXT_149 = NL + "\t\t\t\t\t{" + NL + "\t\t\t\t\t";
  protected final String TEXT_150 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_151 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_152 = ");";
  protected final String TEXT_153 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_154 = " = ";
  protected final String TEXT_155 = "; ";
  protected final String TEXT_156 = NL + "                    System.setProperty(\"java.protocol.handler.pkgs\", \"com.sun.net.ssl.internal.www.protocol\");" + NL + "                    System.setProperty(\"javax.net.ssl.trustStore\", ";
  protected final String TEXT_157 = ");" + NL + "                    System.setProperty(\"javax.net.ssl.trustStorePassword\", decryptedPassword_";
  protected final String TEXT_158 = ");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_159 = NL + NL + "                if (!soapHeaders_";
  protected final String TEXT_160 = ".isEmpty()) {" + NL + "                    genericConsumer_";
  protected final String TEXT_161 = ".setSoapHeaders(soapHeaders_";
  protected final String TEXT_162 = ");" + NL + "                }" + NL + "" + NL + "                responseDoc_";
  protected final String TEXT_163 = " = genericConsumer_";
  protected final String TEXT_164 = ".invoke(requestTalendDoc_";
  protected final String TEXT_165 = ".getDocument());";
  protected final String TEXT_166 = NL + "                    globalMap.put(\"";
  protected final String TEXT_167 = "_CORRELATION_ID\", genericConsumer_";
  protected final String TEXT_168 = ".getCorrelationID());";
  protected final String TEXT_169 = NL + "            } else {" + NL + "                ESBConsumer consumer_";
  protected final String TEXT_170 = " = ";
  protected final String TEXT_171 = ".this.registry.createConsumer(" + NL + "                    new ESBEndpointInfo() {" + NL + "" + NL + "                        @SuppressWarnings(\"serial\")" + NL + "                        private java.util.Map<String, Object> props = new java.util.HashMap<String, Object>() {{" + NL + "                            put(\"dataFormat\", \"PAYLOAD\");" + NL + "                            put(\"portName\", portName_";
  protected final String TEXT_172 = ".toString());" + NL + "                            put(\"serviceName\", serviceName_";
  protected final String TEXT_173 = ".toString());" + NL + "                            put(\"defaultOperationName\", \"";
  protected final String TEXT_174 = "\");" + NL + "                            put(\"operationNamespace\", \"";
  protected final String TEXT_175 = "\");" + NL + "                            put(\"soapAction\", \"";
  protected final String TEXT_176 = "\");" + NL + "                            if (null != getClass().getResourceAsStream(\"wsdl/";
  protected final String TEXT_177 = ".wsdl\")) {" + NL + "                                put(\"wsdlURL\", \"classpath:/\" + this.getClass().getPackage().getName().replace(\".\", \"/\") + \"/wsdl/";
  protected final String TEXT_178 = ".wsdl\");" + NL + "                            }" + NL + "                            put(\"publishedEndpointUrl\", ";
  protected final String TEXT_179 = ");" + NL + "                            put(\"COMMUNICATION_STYLE\", \"";
  protected final String TEXT_180 = "\");" + NL + "" + NL + "                            put(\"logMessages\", ";
  protected final String TEXT_181 = ");" + NL + "" + NL + "                            // use Service Locator" + NL + "                            put(\"useServiceLocator\", ";
  protected final String TEXT_182 = ");";
  protected final String TEXT_183 = NL + "                                put(\"LocatorSelectionStrategy\", \"";
  protected final String TEXT_184 = "\");" + NL + "                                put(\"SL-PROPS\", slCustomProps_";
  protected final String TEXT_185 = ");";
  protected final String TEXT_186 = NL + "                            // use Service Activity Monitor" + NL + "                            put(\"useServiceActivityMonitor\", ";
  protected final String TEXT_187 = ");" + NL + "\t\t\t\t\t\t\tboolean use_auth_";
  protected final String TEXT_188 = " = false;" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_189 = NL + "\t\t\t\t\t\t\t   use_auth_";
  protected final String TEXT_190 = " = ";
  protected final String TEXT_191 = ";" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_192 = NL + "\t\t\t\t\t\t\t   use_auth_";
  protected final String TEXT_193 = " = true; // not from context" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_194 = NL + "                            if (use_auth_";
  protected final String TEXT_195 = " || ";
  protected final String TEXT_196 = ") {" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_197 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_198 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_199 = ");";
  protected final String TEXT_200 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_201 = " = ";
  protected final String TEXT_202 = "; ";
  protected final String TEXT_203 = NL + "  " + NL + "                             if (";
  protected final String TEXT_204 = ") { " + NL + "                                put(\"useServiceRegistry\", ";
  protected final String TEXT_205 = ");" + NL + "                                put(\"username\", ";
  protected final String TEXT_206 = ");" + NL + "" + NL + "                                put(\"password\", decryptedPassword_";
  protected final String TEXT_207 = ");" + NL;
  protected final String TEXT_208 = NL + "                                    put(\"role\", ";
  protected final String TEXT_209 = ");";
  protected final String TEXT_210 = NL + "                                    put(\"useCrypto\", ";
  protected final String TEXT_211 = ");";
  protected final String TEXT_212 = NL + "                             } else if (use_auth_";
  protected final String TEXT_213 = ") { ";
  protected final String TEXT_214 = NL + "                                        put(\"role\", ";
  protected final String TEXT_215 = ");";
  protected final String TEXT_216 = NL + "                                        put(\"useCrypto\", ";
  protected final String TEXT_217 = ");";
  protected final String TEXT_218 = NL + "\t\t\t\t\t\t\t   ";
  protected final String TEXT_219 = NL + "\t\t\t\t\t\t                    put(\"esbSecurity\", ";
  protected final String TEXT_220 = ");" + NL + "\t\t\t\t\t\t\t   ";
  protected final String TEXT_221 = NL + "\t\t\t\t\t                    put(\"esbSecurity\", \"";
  protected final String TEXT_222 = "\");" + NL + "\t\t\t\t\t\t\t   ";
  protected final String TEXT_223 = NL + "                                put(\"username\", ";
  protected final String TEXT_224 = ");" + NL + "                                put(\"password\", decryptedPassword_";
  protected final String TEXT_225 = ");" + NL + "                               } " + NL + "                           }" + NL + "                            if (!soapHeaders_";
  protected final String TEXT_226 = ".isEmpty()) {" + NL + "                                put(\"soapHeaders\", soapHeaders_";
  protected final String TEXT_227 = ");" + NL + "                            }";
  protected final String TEXT_228 = NL + "                                put(\"securityToken\", securityToken_";
  protected final String TEXT_229 = ");";
  protected final String TEXT_230 = NL + "                                String alias_";
  protected final String TEXT_231 = " = ";
  protected final String TEXT_232 = ";" + NL + "                                if (null != alias_";
  protected final String TEXT_233 = " && !\"\".equals(alias_";
  protected final String TEXT_234 = ".trim())) {" + NL + "                                    put(\"alias\", alias_";
  protected final String TEXT_235 = ");" + NL + "                                }";
  protected final String TEXT_236 = NL + "                                put(org.talend.esb.policy.correlation.feature.CorrelationIDFeature.CORRELATION_ID_CALLBACK_HANDLER, correlationIDCallbackHandler);" + NL + "                                put(\"enhancedResponse\", true);";
  protected final String TEXT_237 = NL + "                        }};" + NL + "" + NL + "                        public String getEndpointUri() {" + NL + "                            // projectName + \"_\" + processName + \"_\" + componentName" + NL + "                            return \"";
  protected final String TEXT_238 = "_";
  protected final String TEXT_239 = "_";
  protected final String TEXT_240 = "\";" + NL + "                        }" + NL + "" + NL + "                        public java.util.Map<String, Object> getEndpointProperties() {" + NL + "                            return props;" + NL + "                        }" + NL + "" + NL + "                        public String getEndpointKey() {" + NL + "                            return \"cxf\";" + NL + "                        }" + NL + "                    }" + NL + "                );" + NL + "" + NL + "                Object request_";
  protected final String TEXT_241 = " = wrapPayload(requestTalendDoc_";
  protected final String TEXT_242 = ".getDocument(), customProps_";
  protected final String TEXT_243 = ");" + NL + "                Object consumerResponse_";
  protected final String TEXT_244 = " = consumer_";
  protected final String TEXT_245 = ".invoke(request_";
  protected final String TEXT_246 = ");" + NL + "                if (null == consumerResponse_";
  protected final String TEXT_247 = ") {" + NL + "                    // one way call" + NL + "                } else {" + NL + "                    if(consumerResponse_";
  protected final String TEXT_248 = " instanceof java.util.Map) {" + NL + "                        java.util.Map<?,?> responseMap_";
  protected final String TEXT_249 = " = (java.util.Map<?,?>)consumerResponse_";
  protected final String TEXT_250 = ";" + NL + "                        responseDoc_";
  protected final String TEXT_251 = " = (org.dom4j.Document) responseMap_";
  protected final String TEXT_252 = ".get(\"payload\");";
  protected final String TEXT_253 = NL + "                            globalMap.put(\"";
  protected final String TEXT_254 = "_CORRELATION_ID\", responseMap_";
  protected final String TEXT_255 = ".get(org.talend.esb.policy.correlation.feature.CorrelationIDFeature.MESSAGE_CORRELATION_ID));";
  protected final String TEXT_256 = NL + "                    } else if (consumerResponse_";
  protected final String TEXT_257 = " instanceof org.dom4j.Document) {" + NL + "                        responseDoc_";
  protected final String TEXT_258 = " = (org.dom4j.Document) consumerResponse_";
  protected final String TEXT_259 = ";" + NL + "                    } else {" + NL + "                        throw new RuntimeException(\"Incompatible consumer response: \" + consumerResponse_";
  protected final String TEXT_260 = ".getClass().getName());" + NL + "                    }" + NL + "                }" + NL + "            }";
  protected final String TEXT_261 = NL + "                if (";
  protected final String TEXT_262 = " == null) {";
  protected final String TEXT_263 = NL + "                    ";
  protected final String TEXT_264 = " = new ";
  protected final String TEXT_265 = "Struct();" + NL + "                }" + NL + "                routines.system.Document responseTalendDoc_";
  protected final String TEXT_266 = " = null;" + NL + "                if (null != responseDoc_";
  protected final String TEXT_267 = ") {" + NL + "                    responseTalendDoc_";
  protected final String TEXT_268 = " = new routines.system.Document();" + NL + "                    responseTalendDoc_";
  protected final String TEXT_269 = ".setDocument(responseDoc_";
  protected final String TEXT_270 = ");" + NL + "                }";
  protected final String TEXT_271 = NL + "                ";
  protected final String TEXT_272 = ".payload = responseTalendDoc_";
  protected final String TEXT_273 = ";";
  protected final String TEXT_274 = NL + "        } catch (Exception e_";
  protected final String TEXT_275 = ") {" + NL + "            java.util.Map<String, Object> faultInfo_";
  protected final String TEXT_276 = " = collectFaultInfo(e_";
  protected final String TEXT_277 = ");" + NL + "            if (null == faultInfo_";
  protected final String TEXT_278 = ") {" + NL + "                throw e_";
  protected final String TEXT_279 = "; // non fault exception" + NL + "            }";
  protected final String TEXT_280 = NL + "                if (";
  protected final String TEXT_281 = " == null) {";
  protected final String TEXT_282 = NL + "                    ";
  protected final String TEXT_283 = " = new ";
  protected final String TEXT_284 = "Struct();" + NL + "                }" + NL;
  protected final String TEXT_285 = NL + "                ";
  protected final String TEXT_286 = ".faultCode = (String) faultInfo_";
  protected final String TEXT_287 = ".get(\"faultCode\");";
  protected final String TEXT_288 = NL + "                ";
  protected final String TEXT_289 = ".faultString = (String) faultInfo_";
  protected final String TEXT_290 = ".get(\"faultString\");";
  protected final String TEXT_291 = NL + "                ";
  protected final String TEXT_292 = ".faultActor = (String) faultInfo_";
  protected final String TEXT_293 = ".get(\"faultActor\");";
  protected final String TEXT_294 = NL + "                ";
  protected final String TEXT_295 = ".faultNode = (String) faultInfo_";
  protected final String TEXT_296 = ".get(\"faultNode\");";
  protected final String TEXT_297 = NL + "                ";
  protected final String TEXT_298 = ".faultRole = (String) faultInfo_";
  protected final String TEXT_299 = ".get(\"faultRole\");" + NL + "" + NL + "                if (null != faultInfo_";
  protected final String TEXT_300 = ".get(\"faultDetail\")) {";
  protected final String TEXT_301 = NL + "                    ";
  protected final String TEXT_302 = ".faultDetail = new routines.system.Document();";
  protected final String TEXT_303 = NL + "                    ";
  protected final String TEXT_304 = ".faultDetail.setDocument((org.dom4j.Document) faultInfo_";
  protected final String TEXT_305 = ".get(\"faultDetail\"));" + NL + "                }" + NL;
  protected final String TEXT_306 = NL + "                printFaultInfo(faultInfo_";
  protected final String TEXT_307 = ");" + NL + "                e_";
  protected final String TEXT_308 = ".printStackTrace(System.err);";
  protected final String TEXT_309 = NL + "        }" + NL + "    } catch (Exception e_";
  protected final String TEXT_310 = "){";
  protected final String TEXT_311 = NL + "            throw(e_";
  protected final String TEXT_312 = ");";
  protected final String TEXT_313 = NL + "            new TalendException(e_";
  protected final String TEXT_314 = ",currentComponent,globalMap).printStackTrace();";
  protected final String TEXT_315 = NL + "    }" + NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
/*INIT PARAMETERS AND INDICATORS.*/
NodeConnectionsHelper connsHelper=new NodeConnectionsHelper(node, true);
IConnection inputConn = connsHelper.getInputConn();
if(inputConn == null) {
	return "";//not generate any code if no input connection.
}
IConnection connResponse = connsHelper.getOutputConnResponse();
IConnection connFault = connsHelper.getOutputConnFault();
List<IConnection> dataOutputs = connsHelper.getDataOutputs();

String projectName = codeGenArgument.getCurrentProjectName();
String cid = node.getUniqueName();
String processName = node.getProcess().getName();
String passwordFieldName;

NodeParamsHelper paramsHelper = new NodeParamsHelper(node);
String serviceNS = paramsHelper.getStringParam("__SERVICE_NS__");
String serviceName = paramsHelper.getStringParam("__SERVICE_NAME__");
String portNS = paramsHelper.getStringParam("__PORT_NS__");
String portName = paramsHelper.getStringParam("__PORT_NAME__");

String methodNS = paramsHelper.getStringParam("__METHOD_NS__");
if (methodNS == null || "".equals(methodNS)) {
    methodNS = serviceNS;
}
String methodTemp = paramsHelper.getStringParam("__METHOD__");
String method = methodTemp.indexOf("(") != -1 ? methodTemp.substring(0, methodTemp.indexOf("(")) : methodTemp;

String authType = paramsHelper.getStringParam("__AUTH_TYPE__");
String alias = paramsHelper.getStringParam("__AUTH_ALIAS__");
String username = paramsHelper.getStringParam("__AUTH_USERNAME__");
String authorizationRole = paramsHelper.getStringParam("__ROLE__");
String correlationValue = paramsHelper.getStringParam("__CORRELATION_VALUE__");

boolean logMessages = paramsHelper.getBoolParam("__LOG_MESSAGES__");
String connTimeout = paramsHelper.getStringParam("__CONNECTION_TIMEOUT__");
String receiveTimeout = paramsHelper.getStringParam("__RECEIVE_TIMEOUT__");

//use paramsHelper.getVisibleBoolParam to return false if the controller of this parameter is not visible.
boolean useSR = paramsHelper.getVisibleBoolParam("__USE_SR__");

boolean useSl = paramsHelper.getVisibleBoolParam("__SERVICE_LOCATOR__");
boolean useSAM = paramsHelper.getVisibleBoolParam("__SERVICE_ACTIVITY_MONITOR__");
boolean useAuth = paramsHelper.getVisibleBoolParam("__NEED_AUTH__");
boolean useBusinessCorrelation = paramsHelper.getVisibleBoolParam("__USE_BUSINESS_CORRELATION__");

//saml features
boolean useSAML = useAuth && authType.equals("SAML");
boolean useAuthorization = paramsHelper.getVisibleBoolParam("__NEED_AUTHORIZATION__");

boolean authPropagateUP = false;
boolean authPropagateCertificate = false;
if (useSR) {
    if (paramsHelper.getVisibleBoolParam("__AUTH_PROPAGATE__")) {
        authPropagateUP = true;
        if (alias != null && !"".equals(alias.trim())) {
            authPropagateCertificate = true;
        }
    }
} else {
    String authPropatateType = paramsHelper.getVisibleStringParam("__PROPAGATE_TYPE__");
    authPropagateUP = authPropatateType.equals("U_P");
    authPropagateCertificate = authPropatateType.equals("CERT");
}

boolean useCrypto = paramsHelper.getVisibleBoolParam("__NEED_ENCRYPTION__");

//init headers
boolean hasHeaders = false;
if(inputConn != null) {
    for (IMetadataColumn connColumn : inputConn.getMetadataTable().getListColumns()) {
        if ("headers".equals(connColumn.getLabel())) {
            hasHeaders = true;
            break;
        }
    }
}

/*GENERATE CODE*/
if (inputConn != null) {
    for (IConnection conn : dataOutputs) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_2);
    
    }

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(serviceNS);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(serviceName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(portNS);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(portName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
     if (useSl) { 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    
                for(Entry<String, String> prop : paramsHelper.getPropertiesPram("__SERVICE_LOCATOR_CUSTOM_PROPERTIES__")) {
                    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(prop.getKey());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(prop.getValue());
    stringBuffer.append(TEXT_18);
    
                }
            } 
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
     if (useSAM) {
                List<Entry<String, String>> customProperties = paramsHelper.getPropertiesPram("__SERVICE_ACTIVITY_CUSTOM_PROPERTIES__");
                if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
     for (Entry<String, String> prop : customProperties) { 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(prop.getKey());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(prop.getValue());
    stringBuffer.append(TEXT_26);
     } 
     } 
     } 
     if (useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_27);
    stringBuffer.append(correlationValue);
    stringBuffer.append(TEXT_28);
     } 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
     if (authPropagateUP || authPropagateCertificate) { 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
     List<? extends INode> nodesProviderRequest = node.getProcess().getNodesOfType("tESBProviderRequest");
                if (!nodesProviderRequest.isEmpty()) { 
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(nodesProviderRequest.iterator().next().getUniqueName());
    stringBuffer.append(TEXT_35);
     }
            } if (hasHeaders) { 
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
     } 
    stringBuffer.append(TEXT_43);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(methodNS);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append("request-response".equals(paramsHelper.getStringParam("__COMMUNICATION_STYLE__")));
    stringBuffer.append(TEXT_54);
     String soapAction=paramsHelper.getStringParam("__SOAP_ACTION__");
                    if(soapAction != null && (!soapAction.matches("\\s*"))) { 
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(soapAction);
    stringBuffer.append(TEXT_57);
      } 
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(paramsHelper.getStringParam("__ESB_ENDPOINT__"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
     if (useSl) { 
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
     } 
     if (useSAM) { 
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
     } 
     if (useBusinessCorrelation) { 
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
     } 
     if(useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
     } 
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_90);
    
				  if( node.getElementParameter("NEED_AUTH").isContextMode() ) {
				
    stringBuffer.append(TEXT_91);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_92);
    stringBuffer.append( ElementParameterParser.getValue(node, "__NEED_AUTH__") );
    stringBuffer.append(TEXT_93);
    
				   } else {
			    if ( ElementParameterParser.getValue(node, "__NEED_AUTH__").equals("true") ) {
				
    stringBuffer.append(TEXT_94);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_95);
    
				   }
				}
				
    stringBuffer.append(TEXT_96);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_97);
     if (authType.startsWith("context.") ) { 
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_100);
     } else { 
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_103);
     }
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_106);
     passwordFieldName = "__AUTH_PASSWORD__"; 
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_109);
    } else {
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_112);
    }
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_116);
    
				  if( node.getElementParameter("USE_PROXY").isContextMode() ) {
				
    stringBuffer.append(TEXT_117);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_118);
    stringBuffer.append( ElementParameterParser.getValue(node, "__USE_PROXY__") );
    stringBuffer.append(TEXT_119);
    
				   } else {
			    if ( ElementParameterParser.getValue(node, "__USE_PROXY__").equals("true") ) {
				
    stringBuffer.append(TEXT_120);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_121);
    
				   }
				}
				
    stringBuffer.append(TEXT_122);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_HOST__"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_PORT__"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(paramsHelper.getStringParam("__PROXY_USERNAME__"));
    stringBuffer.append(TEXT_129);
     passwordFieldName = "__PROXY_PASSWORD__"; 
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_132);
    } else {
    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_134);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(connTimeout);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(receiveTimeout);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(paramsHelper.getBoolParam("__FOLLOW_REDIRECTS__"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(!paramsHelper.getBoolParam("__REDIRECT_NON_SAME_HOST__"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(logMessages);
    stringBuffer.append(TEXT_148);
     if (paramsHelper.getBoolParam("__NEED_SSL_TO_TRUSTSERVER__")) {
					passwordFieldName = "__SSL_TRUSTSERVER_PASSWORD__"; 
    stringBuffer.append(TEXT_149);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_152);
    } else {
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_155);
    }
    stringBuffer.append(TEXT_156);
    stringBuffer.append(paramsHelper.getStringParam("__SSL_TRUSTSERVER_TRUSTSTORE__"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
     } 
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_165);
     if (useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
     } 
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(methodNS);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(paramsHelper.getStringParam("__SOAP_ACTION__"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(paramsHelper.getStringParam("__ESB_ENDPOINT__"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(paramsHelper.getStringParam("__COMMUNICATION_STYLE__"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(logMessages);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(useSl);
    stringBuffer.append(TEXT_182);
     if (useSl) { 
    stringBuffer.append(TEXT_183);
    stringBuffer.append(paramsHelper.getStringParam("__SERVICE_LOCATOR_STRATEGY__"));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
     } 
    stringBuffer.append(TEXT_186);
    stringBuffer.append(useSAM);
    stringBuffer.append(TEXT_187);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_188);
    
							  if( node.getElementParameter("NEED_AUTH").isContextMode() ) {
							
    stringBuffer.append(TEXT_189);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append( ElementParameterParser.getValue(node, "__NEED_AUTH__") );
    stringBuffer.append(TEXT_191);
    
							   } else {
						    if ( ElementParameterParser.getValue(node, "__NEED_AUTH__").equals("true") ) {
							
    stringBuffer.append(TEXT_192);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_193);
    
							   }
							}
							
    stringBuffer.append(TEXT_194);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_195);
    stringBuffer.append(useSR);
    stringBuffer.append(TEXT_196);
    	passwordFieldName = "__AUTH_PASSWORD__"; 
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_198);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_199);
    } else {
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_202);
    }
    stringBuffer.append(TEXT_203);
    stringBuffer.append(useSR);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(useSR);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
     if (!authorizationRole.isEmpty() && !"\"\"".equals(authorizationRole)) { 
    stringBuffer.append(TEXT_208);
    stringBuffer.append(authorizationRole);
    stringBuffer.append(TEXT_209);
     } 
     if (useCrypto) { 
    stringBuffer.append(TEXT_210);
    stringBuffer.append(useCrypto);
    stringBuffer.append(TEXT_211);
     } 
    stringBuffer.append(TEXT_212);
    stringBuffer.append( cid );
    stringBuffer.append(TEXT_213);
     if (useSAML) { 
     if (useAuthorization) { 
    stringBuffer.append(TEXT_214);
    stringBuffer.append(authorizationRole);
    stringBuffer.append(TEXT_215);
     }if (useCrypto) { 
    stringBuffer.append(TEXT_216);
    stringBuffer.append(useCrypto);
    stringBuffer.append(TEXT_217);
     } 
     } 
    stringBuffer.append(TEXT_218);
     if (authType.startsWith("context.") ) { 
    stringBuffer.append(TEXT_219);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_220);
     } else { 
    stringBuffer.append(TEXT_221);
    stringBuffer.append(authType);
    stringBuffer.append(TEXT_222);
     }
    stringBuffer.append(TEXT_223);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_227);
     if (authPropagateUP || authPropagateCertificate) { 
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
     }
                            if (authPropagateCertificate) { 
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(alias);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
     }
                            if (useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_236);
     } 
    stringBuffer.append(TEXT_237);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(processName);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
     if (useBusinessCorrelation || useSR) { 
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
     } 
    stringBuffer.append(TEXT_256);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
     if (null != connResponse) {
                String connResponseName = connResponse.getName(); 
    stringBuffer.append(TEXT_261);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(TEXT_263);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
     } 
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
     if (null != connFault) {
                String connFaultName = connFault.getName(); 
    stringBuffer.append(TEXT_280);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_283);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_284);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_300);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(TEXT_303);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
     } else { 
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
     } 
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
     if (paramsHelper.getBoolParam("__DIE_ON_ERROR__")) { 
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_312);
     } else { 
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_314);
     } 
    stringBuffer.append(TEXT_315);
     } 
    return stringBuffer.toString();
  }
}
