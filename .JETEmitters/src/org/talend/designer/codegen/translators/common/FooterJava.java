package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.INode;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.CorePlugin;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import java.util.Vector;
import java.util.List;
import java.util.ArrayList;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IContext;
import org.talend.core.model.process.ProcessUtils;

public class FooterJava
{
  protected static String nl;
  public static synchronized FooterJava create(String lineSeparator)
  {
    nl = lineSeparator;
    FooterJava result = new FooterJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "    public String resuming_logs_dir_path = null;" + NL + "    public String resuming_checkpoint_path = null;" + NL + "    public String parent_part_launcher = null;" + NL + "    private String resumeEntryMethodName = null;" + NL + "    private boolean globalResumeTicket = false;" + NL + "" + NL + "    public boolean watch = false;" + NL + "    // portStats is null, it means don't execute the statistics" + NL + "    public Integer portStats = null;" + NL + "    public int portTraces = 4334;" + NL + "    public String clientHost;" + NL + "    public String defaultClientHost = \"localhost\";" + NL + "    public String contextStr = \"";
  protected final String TEXT_2 = "\";" + NL + "    public boolean isDefaultContext = true;" + NL + "    public String pid = \"0\";" + NL + "    public String rootPid = null;" + NL + "    public String fatherPid = null;" + NL + "    public String fatherNode = null;" + NL + "    public long startTime = 0;" + NL + "    public boolean isChildJob = false;" + NL + "    public String log4jLevel = \"\";" + NL + "" + NL + "    private boolean execStat = true;" + NL + "" + NL + "    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {" + NL + "        protected java.util.Map<String, String> initialValue() {" + NL + "            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();" + NL + "            threadRunResultMap.put(\"errorCode\", null);" + NL + "            threadRunResultMap.put(\"status\", \"\");" + NL + "            return threadRunResultMap;" + NL + "        };" + NL + "    };" + NL;
  protected final String TEXT_3 = NL + "    // ESB Service Activity Monitor Feature" + NL + "    private org.apache.cxf.feature.Feature eventFeature;" + NL + "" + NL + "    public void setEventFeature(org.apache.cxf.feature.Feature eventFeature) {" + NL + "        this.eventFeature = eventFeature;" + NL + "    }";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "    private SyncInt runningThreadCount =new SyncInt();" + NL + "" + NL + "    private class SyncInt" + NL + "    {" + NL + "        private int count = 0;" + NL + "        public synchronized void add(int i)" + NL + "        {" + NL + "            count +=i;" + NL + "        }" + NL + "" + NL + "        public synchronized int getCount()" + NL + "        {" + NL + "            return count;" + NL + "        }" + NL + "    }";
  protected final String TEXT_6 = NL + NL + "    private java.util.Properties context_param = new java.util.Properties();" + NL + "    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();" + NL + "" + NL + "    public String status= \"\";" + NL + "" + NL + "    public static void main(String[] args){" + NL + "        final ";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = "Class = new ";
  protected final String TEXT_9 = "();" + NL + "" + NL + "        int exitCode = ";
  protected final String TEXT_10 = "Class.runJobInTOS(args);";
  protected final String TEXT_11 = NL + "\t        if(exitCode==0){" + NL + "\t\t        log.info(\"TalendJob: '";
  protected final String TEXT_12 = "' - Done.\");" + NL + "\t        }";
  protected final String TEXT_13 = NL + NL + "        System.exit(exitCode);" + NL + "    }" + NL;
  protected final String TEXT_14 = NL + "      @Test" + NL + "        public void test";
  protected final String TEXT_15 = "() throws java.lang.Exception{" + NL + "            junitGlobalMap.put(\"tests.log\",new String());" + NL + "            junitGlobalMap.put(\"tests.nbFailure\",new Integer(0));" + NL + "            final ";
  protected final String TEXT_16 = " ";
  protected final String TEXT_17 = "Class = new ";
  protected final String TEXT_18 = "();" + NL + "            java.util.List<String> paraList_";
  protected final String TEXT_19 = " = new java.util.ArrayList<String>();" + NL + "            paraList_";
  protected final String TEXT_20 = ".add(\"--context=";
  protected final String TEXT_21 = "\");";
  protected final String TEXT_22 = NL + "            java.net.URL url_";
  protected final String TEXT_23 = " = getClass().getResource(\"";
  protected final String TEXT_24 = "\");" + NL + "            String context_";
  protected final String TEXT_25 = "=\"";
  protected final String TEXT_26 = "=\" + url_";
  protected final String TEXT_27 = ".getPath();" + NL + "            paraList_";
  protected final String TEXT_28 = ".add(\"--context_param\");" + NL + "            paraList_";
  protected final String TEXT_29 = ".add(context_";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = "  " + NL + "        String[] arrays = new String[paraList_";
  protected final String TEXT_32 = ".size()];" + NL + "        for(int i=0;i<paraList_";
  protected final String TEXT_33 = ".size();i++){" + NL + "            arrays[i] = (String)paraList_";
  protected final String TEXT_34 = ".get(i);" + NL + "        }";
  protected final String TEXT_35 = NL + "        ";
  protected final String TEXT_36 = "Class.runJobInTOS(arrays);" + NL + "       " + NL + "        String errors = (String)junitGlobalMap.get(\"tests.log\");" + NL + "        Integer nbFailure = (Integer)junitGlobalMap.get(\"tests.nbFailure\");" + NL + "        assertTrue(\"Failure=\"+nbFailure+java.lang.System.getProperty(\"line.separator\")+errors, errors.isEmpty());" + NL + "        " + NL + "         if(";
  protected final String TEXT_37 = "Class.exception!=null){" + NL + "            throw ";
  protected final String TEXT_38 = "Class.exception;" + NL + "        }" + NL + "        }";
  protected final String TEXT_39 = NL + NL + "    public String[][] runJob(String[] args) {" + NL + "" + NL + "        int exitCode = runJobInTOS(args);";
  protected final String TEXT_40 = NL + "        String[][] bufferValue = (String[][])globalBuffer.toArray(new String[globalBuffer.size()][]);";
  protected final String TEXT_41 = NL + "        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };";
  protected final String TEXT_42 = NL + NL + "        return bufferValue;" + NL + "    }" + NL + "" + NL + "    public boolean hastBufferOutputComponent() {" + NL + "\t\tboolean hastBufferOutput = false;" + NL + "    \t";
  protected final String TEXT_43 = NL + "        \t\thastBufferOutput = true;" + NL + "    \t";
  protected final String TEXT_44 = NL + "        return hastBufferOutput;" + NL + "    }" + NL + "" + NL + "    public int runJobInTOS(String[] args) {" + NL + "\t   \t// reset status" + NL + "\t   \tstatus = \"\";" + NL + "" + NL + "        String lastStr = \"\";" + NL + "        for (String arg : args) {" + NL + "            if (arg.equalsIgnoreCase(\"--context_param\")) {" + NL + "                lastStr = arg;" + NL + "            } else if (lastStr.equals(\"\")) {" + NL + "                evalParam(arg);" + NL + "            } else {" + NL + "                evalParam(lastStr + \" \" + arg);" + NL + "                lastStr = \"\";" + NL + "            }" + NL + "        }" + NL;
  protected final String TEXT_45 = NL + "\t        if(!\"\".equals(log4jLevel)){" + NL + "\t\t\t\tif(\"trace\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.TRACE);" + NL + "\t\t\t\t}else if(\"debug\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.DEBUG);" + NL + "\t\t\t\t}else if(\"info\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.INFO);" + NL + "\t\t\t\t}else if(\"warn\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.WARN);" + NL + "\t\t\t\t}else if(\"error\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.ERROR);" + NL + "\t\t\t\t}else if(\"fatal\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.FATAL);" + NL + "\t\t\t\t}else if (\"off\".equalsIgnoreCase(log4jLevel)){" + NL + "\t\t\t\t\tlog.setLevel(org.apache.log4j.Level.OFF);" + NL + "\t\t\t\t}" + NL + "\t\t\t\torg.apache.log4j.Logger.getRootLogger().setLevel(log.getLevel());" + NL + "    \t    }" + NL + "        \tlog.info(\"TalendJob: '";
  protected final String TEXT_46 = "' - Start.\");" + NL + "    \t";
  protected final String TEXT_47 = NL + NL + "        if(clientHost == null) {" + NL + "            clientHost = defaultClientHost;" + NL + "        }" + NL + "" + NL + "        if(pid == null || \"0\".equals(pid)) {" + NL + "            pid = TalendString.getAsciiRandomString(6);" + NL + "        }" + NL + "" + NL + "        if (rootPid==null) {" + NL + "            rootPid = pid;" + NL + "        }" + NL + "        if (fatherPid==null) {" + NL + "            fatherPid = pid;" + NL + "        }else{" + NL + "            isChildJob = true;" + NL + "        }" + NL;
  protected final String TEXT_48 = NL + "        if (portStats != null) {" + NL + "            // portStats = -1; //for testing" + NL + "            if (portStats < 0 || portStats > 65535) {" + NL + "                // issue:10869, the portStats is invalid, so this client socket can't open" + NL + "                System.err.println(\"The statistics socket port \" + portStats + \" is invalid.\");" + NL + "                execStat = false;" + NL + "            }" + NL + "        } else {" + NL + "            execStat = false;" + NL + "        }";
  protected final String TEXT_49 = NL + NL + "        try {" + NL + "            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead." + NL + "            java.io.InputStream inContext = ";
  protected final String TEXT_50 = ".class.getClassLoader().getResourceAsStream(\"";
  protected final String TEXT_51 = "/contexts/\"+contextStr+\".properties\");" + NL + "            if(isDefaultContext && inContext ==null) {" + NL + "" + NL + "            } else {" + NL + "                if (inContext!=null) {" + NL + "                    //defaultProps is in order to keep the original context value" + NL + "                    defaultProps.load(inContext);" + NL + "                    inContext.close();" + NL + "                    context = new ContextProperties(defaultProps);" + NL + "                }else{" + NL + "                    //print info and job continue to run, for case: context_param is not empty." + NL + "                    System.err.println(\"Could not find the context \" + contextStr);" + NL + "                }" + NL + "            }" + NL + "" + NL + "            if(!context_param.isEmpty()) {" + NL + "                context.putAll(context_param);" + NL + "            }";
  protected final String TEXT_52 = NL + "            \t\tString pwd_";
  protected final String TEXT_53 = "_value = context.getProperty(\"";
  protected final String TEXT_54 = "\");" + NL + "            \t\tcontext.";
  protected final String TEXT_55 = " = null;" + NL + "            \t\tif(pwd_";
  protected final String TEXT_56 = "_value!=null) {" + NL + "            \t\t\tif(context_param.containsKey(\"";
  protected final String TEXT_57 = "\")) {//no need to decrypt if it come from program argument or parent job runtime" + NL + "            \t\t\t\tcontext.";
  protected final String TEXT_58 = " = pwd_";
  protected final String TEXT_59 = "_value;" + NL + "            \t\t\t} else if (!pwd_";
  protected final String TEXT_60 = "_value.isEmpty()) {" + NL + "            \t\t\t\ttry {" + NL + "            \t\t\t\t\tcontext.";
  protected final String TEXT_61 = " = routines.system.PasswordEncryptUtil.decryptPassword(pwd_";
  protected final String TEXT_62 = "_value);" + NL + "            \t\t\t\t\tcontext.put(\"";
  protected final String TEXT_63 = "\",context.";
  protected final String TEXT_64 = ");" + NL + "            \t\t\t\t} catch (java.lang.RuntimeException e) {" + NL + "            \t\t\t\t\t//do nothing" + NL + "            \t\t\t\t}" + NL + "            \t\t\t}" + NL + "            \t\t}";
  protected final String TEXT_65 = NL + "            try{" + NL + "                String context_";
  protected final String TEXT_66 = "_value = context.getProperty(\"";
  protected final String TEXT_67 = "\");" + NL + "                if (context_";
  protected final String TEXT_68 = "_value == null){" + NL + "                    context_";
  protected final String TEXT_69 = "_value = \"\";" + NL + "                }" + NL + "                int context_";
  protected final String TEXT_70 = "_pos = context_";
  protected final String TEXT_71 = "_value.indexOf(\";\");" + NL + "                String context_";
  protected final String TEXT_72 = "_pattern =  \"yyyy-MM-dd HH:mm:ss\";" + NL + "                if(context_";
  protected final String TEXT_73 = "_pos > -1){" + NL + "                    context_";
  protected final String TEXT_74 = "_pattern = context_";
  protected final String TEXT_75 = "_value.substring(0, context_";
  protected final String TEXT_76 = "_pos);" + NL + "                    context_";
  protected final String TEXT_77 = "_value = context_";
  protected final String TEXT_78 = "_value.substring(context_";
  protected final String TEXT_79 = "_pos + 1);" + NL + "                }" + NL + "" + NL + "                context.";
  protected final String TEXT_80 = "=(java.util.Date)(new java.text.SimpleDateFormat(context_";
  protected final String TEXT_81 = "_pattern).parse(context_";
  protected final String TEXT_82 = "_value));" + NL + "" + NL + "            }catch(ParseException e)" + NL + "            {" + NL + "                context.";
  protected final String TEXT_83 = "=null;" + NL + "            }";
  protected final String TEXT_84 = NL + "                context.";
  protected final String TEXT_85 = "=(";
  protected final String TEXT_86 = ") context.getProperty(\"";
  protected final String TEXT_87 = "\");";
  protected final String TEXT_88 = NL + "             context.";
  protected final String TEXT_89 = "= new java.text.StringCharacterIterator(context.getProperty(\"";
  protected final String TEXT_90 = "\")).first();";
  protected final String TEXT_91 = NL + "             try{" + NL + "                 context.";
  protected final String TEXT_92 = "=routines.system.ParserUtils.parseTo_";
  protected final String TEXT_93 = " (context.getProperty(\"";
  protected final String TEXT_94 = "\"));" + NL + "             }catch(NumberFormatException e){" + NL + "                 context.";
  protected final String TEXT_95 = "=null;" + NL + "              }";
  protected final String TEXT_96 = NL + "        } catch (java.io.IOException ie) {" + NL + "            System.err.println(\"Could not load context \"+contextStr);" + NL + "            ie.printStackTrace();" + NL + "        }" + NL + "" + NL + "" + NL + "        // get context value from parent directly" + NL + "        if (parentContextMap != null && !parentContextMap.isEmpty()) {";
  protected final String TEXT_97 = "if (parentContextMap.containsKey(\"";
  protected final String TEXT_98 = "\")) {" + NL + "                context.";
  protected final String TEXT_99 = " = (";
  protected final String TEXT_100 = ") parentContextMap.get(\"";
  protected final String TEXT_101 = "\");" + NL + "            }";
  protected final String TEXT_102 = NL + "        }" + NL + "" + NL + "        //Resume: init the resumeUtil" + NL + "        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);" + NL + "        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);" + NL + "        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);" + NL + "" + NL + "\t\tList<String> parametersToEncrypt = new java.util.ArrayList<String>();";
  protected final String TEXT_103 = NL + "\t\t\tparametersToEncrypt.add(\"";
  protected final String TEXT_104 = "\");";
  protected final String TEXT_105 = NL + "        //Resume: jobStart" + NL + "        resumeUtil.addLog(\"JOB_STARTED\", \"JOB:\" + jobName, parent_part_launcher, Thread.currentThread().getId() + \"\", \"\",\"\",\"\",\"\",resumeUtil.convertToJsonText(context,parametersToEncrypt));" + NL;
  protected final String TEXT_106 = NL + "if(execStat) {" + NL + "    try {" + NL + "        runStat.openSocket(!isChildJob);" + NL + "        runStat.setAllPID(rootPid, fatherPid, pid, jobName);" + NL + "        runStat.startThreadStat(clientHost, portStats);" + NL + "        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);" + NL + "    } catch (java.io.IOException ioException) {" + NL + "        ioException.printStackTrace();" + NL + "    }" + NL + "}";
  protected final String TEXT_107 = NL;
  protected final String TEXT_108 = NL + "    try {" + NL + "        runTrace.openSocket(!isChildJob);" + NL + "        runTrace.startThreadTrace(clientHost, portTraces);" + NL + "    } catch (java.io.IOException ioException) {" + NL + "        ioException.printStackTrace();" + NL + "    }";
  protected final String TEXT_109 = NL;
  protected final String TEXT_110 = NL;
  protected final String TEXT_111 = NL + "\t";
  protected final String TEXT_112 = NL + "\t    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();" + NL + "\t    globalMap.put(\"concurrentHashMap\", concurrentHashMap);" + NL + "\t";
  protected final String TEXT_113 = NL + NL + "    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();" + NL + "    long endUsedMemory = 0;" + NL + "    long end = 0;" + NL + "" + NL + "    startTime = System.currentTimeMillis();";
  protected final String TEXT_114 = NL + "        ";
  protected final String TEXT_115 = ".addMessage(\"begin\");";
  protected final String TEXT_116 = NL;
  protected final String TEXT_117 = NL;
  protected final String TEXT_118 = NL + NL + "this.globalResumeTicket = true;//to run tPreJob" + NL;
  protected final String TEXT_119 = NL;
  protected final String TEXT_120 = NL + NL;
  protected final String TEXT_121 = NL + "        try {";
  protected final String TEXT_122 = NL + "            ";
  protected final String TEXT_123 = "Process(globalMap);" + NL + "        } catch (java.lang.Exception e) {" + NL + "            e.printStackTrace();" + NL + "        }";
  protected final String TEXT_124 = NL + NL + "this.globalResumeTicket = false;//to run others jobs" + NL;
  protected final String TEXT_125 = NL + "        runningThreadCount.add(1);" + NL + "        new Thread(){" + NL + "            public void run() {" + NL + "                java.util.Map threadRunResultMap = new java.util.HashMap();" + NL + "                threadRunResultMap.put(\"errorCode\", null);" + NL + "                threadRunResultMap.put(\"status\", \"\");" + NL + "                threadLocal.set(threadRunResultMap);" + NL;
  protected final String TEXT_126 = NL + "                ";
  protected final String TEXT_127 = NL + "                finally {" + NL + "                    Integer localErrorCode = (Integer)(((java.util.Map)threadLocal.get()).get(\"errorCode\"));" + NL + "                    String localStatus = (String)(((java.util.Map)threadLocal.get()).get(\"status\"));" + NL + "                    if (localErrorCode != null) {" + NL + "                        if (errorCode == null || localErrorCode.compareTo(errorCode) > 0) {" + NL + "                           errorCode = localErrorCode;" + NL + "                        }" + NL + "                    }" + NL + "                    if (!status.equals(\"failure\")){" + NL + "                        status = localStatus;" + NL + "                    }" + NL + "" + NL + "                    runningThreadCount.add(-1);" + NL + "                }" + NL + "            }" + NL + "        }.start();" + NL;
  protected final String TEXT_128 = NL + "    while (runningThreadCount.getCount() > 0) {" + NL + "        try {" + NL + "            Thread.sleep(10);" + NL + "        } catch (java.lang.Exception e) {" + NL + "            e.printStackTrace();" + NL + "        }" + NL + "    }";
  protected final String TEXT_129 = NL;
  protected final String TEXT_130 = NL + NL + "this.globalResumeTicket = true;//to run tPostJob" + NL;
  protected final String TEXT_131 = NL;
  protected final String TEXT_132 = NL;
  protected final String TEXT_133 = NL;
  protected final String TEXT_134 = NL + NL + "        end = System.currentTimeMillis();" + NL + "" + NL + "        if (watch) {" + NL + "            System.out.println((end-startTime)+\" milliseconds\");" + NL + "        }" + NL + "" + NL + "        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();" + NL + "        if (false) {" + NL + "            System.out.println((endUsedMemory - startUsedMemory) + \" bytes memory increase when running : ";
  protected final String TEXT_135 = "\");" + NL + "        }";
  protected final String TEXT_136 = NL + "        ";
  protected final String TEXT_137 = ".addMessage(status==\"\"?\"end\":status, (end-startTime));" + NL + "        try {";
  protected final String TEXT_138 = NL + "            ";
  protected final String TEXT_139 = "Process(globalMap);" + NL + "        } catch (java.lang.Exception e) {" + NL + "            e.printStackTrace();" + NL + "        }";
  protected final String TEXT_140 = NL;
  protected final String TEXT_141 = NL + "    closeJmsConnections();";
  protected final String TEXT_142 = NL;
  protected final String TEXT_143 = NL + "    closeScpConnections();";
  protected final String TEXT_144 = NL;
  protected final String TEXT_145 = NL + "    if (false";
  protected final String TEXT_146 = " || null == eventFeature";
  protected final String TEXT_147 = " || null == registry";
  protected final String TEXT_148 = ") { // TESB-8574: Fix SAM timeout issue in Studio" + NL + "        try {" + NL + "            Thread.sleep(5000);" + NL + "        } catch (InterruptedException e) {" + NL + "        }" + NL + "    }";
  protected final String TEXT_149 = NL + NL;
  protected final String TEXT_150 = NL + "if (execStat) {" + NL + "    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);" + NL + "    runStat.stopThreadStat();" + NL + "}";
  protected final String TEXT_151 = NL + "        runTrace.stopThreadTrace();";
  protected final String TEXT_152 = NL + "    int returnCode = 0;" + NL + "    if(errorCode == null) {" + NL + "         returnCode = status != null && status.equals(\"failure\") ? 1 : 0;" + NL + "    } else {" + NL + "         returnCode = errorCode.intValue();" + NL + "    }" + NL + "    resumeUtil.addLog(\"JOB_ENDED\", \"JOB:\" + jobName, parent_part_launcher, Thread.currentThread().getId() + \"\", \"\",\"\" + returnCode,\"\",\"\",\"\");" + NL + "" + NL + "    return returnCode;" + NL + "" + NL + "  }" + NL + "" + NL + "    // only for OSGi env" + NL + "    public void destroy() {";
  protected final String TEXT_153 = NL + "    closeJmsConnections();";
  protected final String TEXT_154 = NL + "    closeScpConnections();";
  protected final String TEXT_155 = NL + "    closeSqlDbConnections();";
  protected final String TEXT_156 = NL + "    }" + NL;
  protected final String TEXT_157 = NL + "    private void closeJmsConnections() {" + NL + "        try {" + NL + "            Object obj_conn;";
  protected final String TEXT_158 = NL + "            obj_conn = globalMap.remove(\"connection_";
  protected final String TEXT_159 = "\");" + NL + "            if (null != obj_conn) {" + NL + "                ((javax.jms.Connection) obj_conn).close();" + NL + "            }";
  protected final String TEXT_160 = NL + "        } catch (java.lang.Exception e) {" + NL + "        }" + NL + "    }";
  protected final String TEXT_161 = NL;
  protected final String TEXT_162 = NL + "    private void closeScpConnections() {" + NL + "        try {" + NL + "            Object obj_conn;";
  protected final String TEXT_163 = NL + "            obj_conn = globalMap.remove(\"conn_";
  protected final String TEXT_164 = "\");" + NL + "            if (null != obj_conn) {" + NL + "                ((ch.ethz.ssh2.Connection) obj_conn).close();" + NL + "            }";
  protected final String TEXT_165 = NL + "        } catch (java.lang.Exception e) {" + NL + "        }" + NL + "    }";
  protected final String TEXT_166 = NL;
  protected final String TEXT_167 = NL + "    private void closeSqlDbConnections() {" + NL + "        try {" + NL + "            Object obj_conn;";
  protected final String TEXT_168 = NL + "            obj_conn = globalMap.remove(\"conn_";
  protected final String TEXT_169 = "\");" + NL + "            if (null != obj_conn) {" + NL + "                ((java.sql.Connection) obj_conn).close();" + NL + "            }";
  protected final String TEXT_170 = NL + "        } catch (java.lang.Exception e) {" + NL + "        }" + NL + "    }";
  protected final String TEXT_171 = NL + NL + NL + "    private java.util.Map<String, Object> getSharedConnections4REST() {" + NL + "        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();";
  protected final String TEXT_172 = NL + "            connections.put(\"connection_";
  protected final String TEXT_173 = "\", globalMap.get(\"connection_";
  protected final String TEXT_174 = "\"));" + NL + "            connections.put(\"session_";
  protected final String TEXT_175 = "\", globalMap.get(\"session_";
  protected final String TEXT_176 = "\"));";
  protected final String TEXT_177 = NL + "            connections.put(\"conn_";
  protected final String TEXT_178 = "\", globalMap.get(\"conn_";
  protected final String TEXT_179 = "\"));";
  protected final String TEXT_180 = NL + "            connections.put(\"conn_";
  protected final String TEXT_181 = "\", globalMap.get(\"conn_";
  protected final String TEXT_182 = "\"));";
  protected final String TEXT_183 = NL + "        return connections;" + NL + "    }" + NL + "" + NL + "    private void evalParam(String arg) {" + NL + "        if (arg.startsWith(\"--resuming_logs_dir_path\")) {" + NL + "            resuming_logs_dir_path = arg.substring(25);" + NL + "        } else if (arg.startsWith(\"--resuming_checkpoint_path\")) {" + NL + "            resuming_checkpoint_path = arg.substring(27);" + NL + "        } else if (arg.startsWith(\"--parent_part_launcher\")) {" + NL + "            parent_part_launcher = arg.substring(23);" + NL + "        } else if (arg.startsWith(\"--watch\")) {" + NL + "            watch = true;" + NL + "        } else if (arg.startsWith(\"--stat_port=\")) {" + NL + "            String portStatsStr = arg.substring(12);" + NL + "            if (portStatsStr != null && !portStatsStr.equals(\"null\")) {" + NL + "                portStats = Integer.parseInt(portStatsStr);" + NL + "            }" + NL + "        } else if (arg.startsWith(\"--trace_port=\")) {" + NL + "            portTraces = Integer.parseInt(arg.substring(13));" + NL + "        } else if (arg.startsWith(\"--client_host=\")) {" + NL + "            clientHost = arg.substring(14);" + NL + "        } else if (arg.startsWith(\"--context=\")) {" + NL + "            contextStr = arg.substring(10);" + NL + "            isDefaultContext = false;" + NL + "        } else if (arg.startsWith(\"--father_pid=\")) {" + NL + "            fatherPid = arg.substring(13);" + NL + "        } else if (arg.startsWith(\"--root_pid=\")) {" + NL + "            rootPid = arg.substring(11);" + NL + "        } else if (arg.startsWith(\"--father_node=\")) {" + NL + "            fatherNode = arg.substring(14);" + NL + "        } else if (arg.startsWith(\"--pid=\")) {" + NL + "            pid = arg.substring(6);" + NL + "        } else if (arg.startsWith(\"--context_param\")) {" + NL + "            String keyValue = arg.substring(16);" + NL + "            int index = -1;" + NL + "            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {" + NL + "                if (fatherPid==null) {" + NL + "                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));" + NL + "                } else { // the subjob won't escape the especial chars" + NL + "                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );" + NL + "                }" + NL + "            }" + NL + "        }else if (arg.startsWith(\"--log4jLevel=\")) {" + NL + "            log4jLevel = arg.substring(13);" + NL + "\t\t}" + NL + "" + NL + "    }" + NL + "" + NL + "    private final String[][] escapeChars = {" + NL + "        {\"\\\\\\\\\",\"\\\\\"},{\"\\\\n\",\"\\n\"},{\"\\\\'\",\"\\'\"},{\"\\\\r\",\"\\r\"}," + NL + "        {\"\\\\f\",\"\\f\"},{\"\\\\b\",\"\\b\"},{\"\\\\t\",\"\\t\"}" + NL + "        };" + NL + "    private String replaceEscapeChars (String keyValue) {" + NL + "" + NL + "\t\tif (keyValue == null || (\"\").equals(keyValue.trim())) {" + NL + "\t\t\treturn keyValue;" + NL + "\t\t}" + NL + "" + NL + "\t\tStringBuilder result = new StringBuilder();" + NL + "\t\tint currIndex = 0;" + NL + "\t\twhile (currIndex < keyValue.length()) {" + NL + "\t\t\tint index = -1;" + NL + "\t\t\t// judege if the left string includes escape chars" + NL + "\t\t\tfor (String[] strArray : escapeChars) {" + NL + "\t\t\t\tindex = keyValue.indexOf(strArray[0],currIndex);" + NL + "\t\t\t\tif (index>=0) {" + NL + "" + NL + "\t\t\t\t\tresult.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));" + NL + "\t\t\t\t\tcurrIndex = index + strArray[0].length();" + NL + "\t\t\t\t\tbreak;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\t// if the left string doesn't include escape chars, append the left into the result" + NL + "\t\t\tif (index < 0) {" + NL + "\t\t\t\tresult.append(keyValue.substring(currIndex));" + NL + "\t\t\t\tcurrIndex = currIndex + keyValue.length();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\treturn result.toString();" + NL + "    }" + NL + "" + NL + "    public Integer getErrorCode() {" + NL + "        return errorCode;" + NL + "    }" + NL + "" + NL + "" + NL + "    public String getStatus() {" + NL + "        return status;" + NL + "    }" + NL + "" + NL + "    ResumeUtil resumeUtil = null;" + NL + "}";

    private static String end_multiThread = "if ( !\"failure\".equals(((java.util.Map)threadLocal.get()).get(\"status\")) ) {\n((java.util.Map) threadLocal.get()).put(\"status\", \"end\");\n}";
    private static String end_singleThread = "if(!\"failure\".equals(status)) { status = \"end\"; }";
    private static String failure_multiThread = "((java.util.Map) threadLocal.get()).put(\"status\", \"failure\");";
    private static String failure_singleThread = "status = \"failure\";";
    private static String errorCode_multiThread = "((java.util.Map) threadLocal.get()).put(\"errorCode\", null);";
    private static String errorCode_singleThread = "errorCode = null;";
    
    // add the list of the connection names to avoid to declare two times the same name.
    public String createCallProcess(INode rootNode, String className, boolean isMultiThread) {
        String toReturn = "";
        toReturn =  "try {\n";
        if(isMultiThread) {
            toReturn +=  errorCode_multiThread;
        }else{
            toReturn +=  errorCode_singleThread;
        }        
        
        toReturn += rootNode.getUniqueName() + "Process(globalMap);\n";
        
        if(isMultiThread) {
            toReturn +=  end_multiThread;
        }else{
            toReturn +=  end_singleThread;
        }
        
        toReturn += "\n}catch (TalendException e_" + rootNode.getUniqueName() + ") {\n";
        
//        if(isMultiThread) {
//            toReturn +=  failure_multiThread;
//        }else{
//            toReturn +=  failure_singleThread;
//        }
        
        toReturn += "globalMap.put(\""+rootNode.getUniqueName()+ "_SUBPROCESS_STATE\", -1);\n";
        
        toReturn += "\ne_" + rootNode.getUniqueName() + ".printStackTrace();\n";
        
      
       //List< ? extends IConnection> onSubJobErrorConns = rootNode.getOutgoingConnections(EConnectionType.ON_SUBJOB_ERROR);
       //if(onSubJobErrorConns!=null){
       //    for(IConnection conn : onSubJobErrorConns) {               
       //        toReturn += createCallProcess(conn.getTarget(),  className, isMultiThread);
       //    }
       //}            
        if(isMultiThread){
            toReturn += "\n}catch (Error e_" + rootNode.getUniqueName() + ") {\n";
            toReturn += "globalMap.put(\""+rootNode.getUniqueName()+ "_SUBPROCESS_STATE\", -1);\n";
            toReturn += "\ne_" + rootNode.getUniqueName() + ".printStackTrace();\n";
        }
       toReturn += "\n}"; 
       return toReturn;
    }
		 
    public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    Vector v = (Vector) codeGenArgument.getArgument();
    IProcess process = (IProcess)v.get(0);
    String className = process.getName();
    boolean isTestContainer=ProcessUtils.isTestContainer(process);
    if (isTestContainer) {
        className = className + "Test";
    }
    
    List<INode> rootNodes = (List<INode>)v.get(1);
	boolean containsTPartitioner = process.getNodesOfType("tPartitioner").size() > 0 ? true : false;
    boolean stats = codeGenArgument.isStatistics();
    boolean trace = codeGenArgument.isTrace();
    boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();
    List<IContextParameter> params = new ArrayList<IContextParameter>();
    params=process.getContextManager().getDefaultContext().getContextParameterList();
    
	String jobFolderName = "";
	IProcess baseProcess = ProcessUtils.getTestContainerBaseProcess(process);
	if (baseProcess != null) {
		jobFolderName = JavaResourcesHelper.getJobFolderName(baseProcess.getName(), baseProcess.getVersion()) + '/';
	}
	jobFolderName = jobFolderName + JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
	String jobClassPackageFolder = codeGenArgument.getCurrentProjectName().toLowerCase() + '/' + jobFolderName;

    boolean isLog4jEnabled = ("true").equals(ElementParameterParser.getValue(process, "__LOG4J_ACTIVATE__"));

    boolean exist_tParallelize = false;
    List<? extends INode> tParallelizeList = process.getNodesOfType("tParallelize");
    if(tParallelizeList != null && tParallelizeList.size() > 0){
        exist_tParallelize = true;
    }

    boolean exist_tMOM = false;
    List<INode> momComponentsList = (List<INode>)process.getNodesOfType("tMomConnection");
    momComponentsList.addAll((List<INode>)process.getNodesOfType("tMomInput"));
    momComponentsList.addAll((List<INode>)process.getNodesOfType("tMomOutput"));
    if (momComponentsList.size() > 0) {
        exist_tMOM = true;
    }

    String[] sqlDbComponents = new String[] {
        "tAccessConnection",
        "tAmazonMysqlConnection",
        "tAmazonOracleConnection",
        "tAS400Connection",
        "tDB2Connection",
        "tFirebirdConnection",
        "tGreenplumConnection",
        "tHiveConnection",
        "tInformixConnection",
        "tIngresConnection",
        "tInterbaseConnection",
        "tJDBCConnection",
        "tMSSqlConnection",
        "tMysqlConnection",
        "tNetezzaConnection",
        "tOracleConnection",
        "tParAccelConnection",
        "tPostgresPlusConnection",
        "tPostgresqlConnection",
        "tRedshiftConnection",
        "tSQLiteConnection",
        "tSybaseConnection",
        "tTeradataConnection",
        "tVectorWiseConnection",
        "tVerticaConnection"
    };
    boolean exist_tSQLDB = false;
    List<INode> sqlDbComponentsList =  new ArrayList<INode>();
    for (String sqlDbComponent : sqlDbComponents) {
        sqlDbComponentsList.addAll((List<INode>)process.getNodesOfType(sqlDbComponent));
    }
    if (sqlDbComponentsList.size() > 0) {
        exist_tSQLDB = true;
    }

    boolean exist_tSCP = false;
    List<INode> scpComponentsList = (List<INode>)process.getNodesOfType("tSCPConnection");
    if (scpComponentsList.size() > 0) {
        exist_tSCP = true;
    }

    boolean hasSAM4RS = false;
    for (INode node : process.getNodesOfType("tRESTClient")) {
        if (Boolean.valueOf(ElementParameterParser.getValue(node, "__SERVICE_ACTIVITY_MONITOR__"))) {
            hasSAM4RS = true;
            break;
        }
    }
    boolean hasSAM4WS = false;
    for (INode node : process.getNodesOfType("tESBConsumer")) {
        if (Boolean.valueOf(ElementParameterParser.getValue(node, "__SERVICE_ACTIVITY_MONITOR__"))) {
            hasSAM4WS = true;
            break;
        }
    }


    stringBuffer.append(TEXT_1);
    stringBuffer.append(codeGenArgument.getContextName() );
    stringBuffer.append(TEXT_2);
     if (hasSAM4RS) { 
    stringBuffer.append(TEXT_3);
     } 
    stringBuffer.append(TEXT_4);
    
    if(isRunInMultiThread || exist_tParallelize){

    stringBuffer.append(TEXT_5);
    
    }

    stringBuffer.append(TEXT_6);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_10);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(codeGenArgument.getJobName());
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
     
    if (isTestContainer) {
        List<IContext> contexts = process.getContextManager().getListContext();   
        for (IContext context : contexts)
        {
        
    stringBuffer.append(TEXT_14);
    stringBuffer.append(context.getName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(context.getName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(context.getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(context.getName());
    stringBuffer.append(TEXT_21);
    
        for(IContextParameter contextPara:context.getContextParameterList()){
            String path =  ProcessUtils.getTestDataValue(process, context, contextPara);
            if(path!=null&&path.length()>0){
            
    stringBuffer.append(TEXT_22);
    stringBuffer.append(contextPara.getName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(path);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(contextPara.getName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(contextPara.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(contextPara.getName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(context.getName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(context.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(contextPara.getName());
    stringBuffer.append(TEXT_30);
    
         }
               
        }
        
    stringBuffer.append(TEXT_31);
    stringBuffer.append(context.getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(context.getName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(context.getName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_38);
    
        }
    }
    
    stringBuffer.append(TEXT_39);
    
        List<INode> tBufferNodes = (List<INode>)process.getNodesOfType("tBufferOutput");
        if(tBufferNodes != null && tBufferNodes.size() > 0) {
    
    stringBuffer.append(TEXT_40);
    
        } else {
    
    stringBuffer.append(TEXT_41);
    
        }
    
    stringBuffer.append(TEXT_42);
    //For TDI-28558
        	List<INode> tBufferNodesList = (List<INode>)process.getNodesOfType("tBufferOutput");
        	if(tBufferNodesList != null && tBufferNodesList.size() > 0) {
    	
    stringBuffer.append(TEXT_43);
    
        	}
		
    stringBuffer.append(TEXT_44);
    if(isLog4jEnabled){
    stringBuffer.append(TEXT_45);
    stringBuffer.append(codeGenArgument.getJobName());
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    
        if (stats) {

    stringBuffer.append(TEXT_48);
    
        }

    stringBuffer.append(TEXT_49);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(jobClassPackageFolder);
    stringBuffer.append(TEXT_51);
     for (IContextParameter ctxParam :params)
            {
            	if (ctxParam.getType().equals("id_Password")) {
            
    stringBuffer.append(TEXT_52);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_64);
    
            		continue;
            	}
                String typeToGenerate ="String";
                if( !(ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory") ||ctxParam.getType().equals("id_List Of Value")))
                {
                   typeToGenerate=JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
                }
                if(typeToGenerate.equals("java.util.Date"))
                {

            
    stringBuffer.append(TEXT_65);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_83);
    
                }else if(typeToGenerate.equals("Object")||typeToGenerate.equals("String")||typeToGenerate.equals("java.lang.String") )
                {
                
    stringBuffer.append(TEXT_84);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_87);
    
                }else if(typeToGenerate.equals("Character")&&ctxParam.getName()!=null)
                {
             
    stringBuffer.append(TEXT_88);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_90);
    
                } else {
             
    stringBuffer.append(TEXT_91);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_95);
    
                }
            }
            
    stringBuffer.append(TEXT_96);
     for (IContextParameter ctxParam :params){
            //about the type, they are same as header.javajet
            String typeToGenerate = "String";
            if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory")){
                typeToGenerate = "String";
            }else{
                typeToGenerate = JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true);
            }
        
    stringBuffer.append(TEXT_97);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_99);
    stringBuffer.append(typeToGenerate );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
     		for(IContextParameter ctxParam :params) {
        	if ("id_Password".equals(ctxParam.getType())) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_104);
    
        	}
        }

    stringBuffer.append(TEXT_105);
    
        if (stats) {

    stringBuffer.append(TEXT_106);
    
    }

    stringBuffer.append(TEXT_107);
    
    if (trace) {

    stringBuffer.append(TEXT_108);
    
    }

    stringBuffer.append(TEXT_109);
    stringBuffer.append(TEXT_110);
    stringBuffer.append( ElementParameterParser.getValue(process, "__HEADER_CODE__"));
    stringBuffer.append(TEXT_111);
    //if(containsTPartitioner){//as tMatchGroupIn and tFuzzyUniqRow use this concurrentHashMap, so generate always
    stringBuffer.append(TEXT_112);
    //}
    stringBuffer.append(TEXT_113);
    
        //1. send the begin msg

        for (INode statCatcherNode : process.getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_115);
    
        }

        List<INode> prejobNodes = new ArrayList<INode>();

        List<INode> postjobNodes = new ArrayList<INode>();

        INode implicit_Context = null;

        for (INode rootNode : rootNodes) {
            String componentName = rootNode.getComponent().getName();
            String uniqueName = rootNode.getUniqueName();

            if (componentName.equals("tPrejob")) {
                prejobNodes.add(rootNode);
                continue;
            }

            if (componentName.equals("tPostjob")) {
                postjobNodes.add(rootNode);
                continue;
            }

            if (uniqueName.startsWith("Implicit_Context_")) {
                implicit_Context = rootNode;
                continue;
            }
        }

    stringBuffer.append(TEXT_116);
    
//2. load implicit contextload
 if(implicit_Context != null) {

    stringBuffer.append(TEXT_117);
    stringBuffer.append(createCallProcess(implicit_Context, className, false) );
    
 }

    stringBuffer.append(TEXT_118);
    
//3. run pre-job
 if(!prejobNodes.isEmpty()) {
    for(INode preNode:prejobNodes) {

    stringBuffer.append(TEXT_119);
    stringBuffer.append(createCallProcess(preNode, className, false) );
    
    }
 }

    stringBuffer.append(TEXT_120);
    
        //4. flush the begin msg
        for (INode statCatcherNode : process.getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_121);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(statCatcherNode.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_123);
    
        }

    stringBuffer.append(TEXT_124);
    

    //5. all others sub-job (MultiThread mode)
    if(isRunInMultiThread){
        for (INode rootNode : rootNodes) {
            String componentName = rootNode.getComponent().getName();
            String uniqueName = rootNode.getUniqueName();

            //filter the special subjob
            if("tPrejob".equals(componentName)) continue;
            if("tPostjob".equals(componentName)) continue;

            //bug16808 when use parallel option at Output components, that will multi thread
            if(componentName.startsWith("tAsyncIn")) continue;
            //end bug16808

            if(implicit_Context!=null && implicit_Context.getUniqueName().equals(uniqueName)) continue;

            if (!componentName.equals("tLogCatcher") && !componentName.equals("tFlowMeterCatcher") && !componentName.equals("tAssertCatcher") && !componentName.equals("tStatCatcher")) {

    stringBuffer.append(TEXT_125);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(createCallProcess(rootNode, className, true) );
    stringBuffer.append(TEXT_127);
    
            }
        }

    stringBuffer.append(TEXT_128);
    
    } else { // isRunInMultiThread  //5. all others sub-job (SingleThread  mode)
        for (INode rootNode : rootNodes) {
            String componentName = rootNode.getComponent().getName();
            String uniqueName = rootNode.getUniqueName();

            //filter the special subjob
            if("tPrejob".equals(componentName)) continue;
            if("tPostjob".equals(componentName)) continue;
            if(implicit_Context!=null && implicit_Context.getUniqueName().equals(uniqueName)) continue;

            if (!componentName.equals("tLogCatcher") && !componentName.equals("tFlowMeterCatcher") && !componentName.equals("tAssertCatcher") && !componentName.equals("tStatCatcher") && !componentName.equals("tAsyncIn")) {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(createCallProcess(rootNode, className, false) );
        }
    }
}// end if(isRunInMultiThread)

    stringBuffer.append(TEXT_130);
    
//6. run the post-job
 if(!postjobNodes.isEmpty()){
    for(INode postNode:postjobNodes){

    stringBuffer.append(TEXT_131);
    stringBuffer.append(createCallProcess(postNode, className, false) );
    
    }
 }

    stringBuffer.append(TEXT_132);
    stringBuffer.append(TEXT_133);
    stringBuffer.append( ElementParameterParser.getValue(process, "__FOOTER_CODE__"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(className );
    stringBuffer.append(TEXT_135);
    
    //7. send & flush the end msg to statcatcher
    for (INode statCatcherNode : process.getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_136);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(statCatcherNode.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_139);
    
    }

    stringBuffer.append(TEXT_140);
     if (exist_tMOM) { 
    stringBuffer.append(TEXT_141);
     } 
    stringBuffer.append(TEXT_142);
     if (exist_tSCP) { 
    stringBuffer.append(TEXT_143);
     } 
    stringBuffer.append(TEXT_144);
    
    if (hasSAM4RS || hasSAM4WS) {

    stringBuffer.append(TEXT_145);
     if (hasSAM4RS) { 
    stringBuffer.append(TEXT_146);
     } 
     if (hasSAM4WS) { 
    stringBuffer.append(TEXT_147);
     } 
    stringBuffer.append(TEXT_148);
    
    }

    stringBuffer.append(TEXT_149);
    
    if (stats) {

    stringBuffer.append(TEXT_150);
    
    }

    if (trace) {

    stringBuffer.append(TEXT_151);
    
    }

    stringBuffer.append(TEXT_152);
     if(exist_tMOM) { 
    stringBuffer.append(TEXT_153);
     } 
     if(exist_tSCP) { 
    stringBuffer.append(TEXT_154);
     } 
     if (exist_tSQLDB) { 
    stringBuffer.append(TEXT_155);
     } 
    stringBuffer.append(TEXT_156);
    
    if(exist_tMOM) {

    stringBuffer.append(TEXT_157);
    
            for (INode momNode : momComponentsList) {

    stringBuffer.append(TEXT_158);
    stringBuffer.append(momNode.getUniqueName() );
    stringBuffer.append(TEXT_159);
    
            }

    stringBuffer.append(TEXT_160);
    
    }

    stringBuffer.append(TEXT_161);
    
    if(exist_tSCP) {

    stringBuffer.append(TEXT_162);
    
            for (INode scpNode : scpComponentsList) {

    stringBuffer.append(TEXT_163);
    stringBuffer.append(scpNode.getUniqueName() );
    stringBuffer.append(TEXT_164);
    
            }

    stringBuffer.append(TEXT_165);
    
    }

    stringBuffer.append(TEXT_166);
      if(exist_tSQLDB) { 
    stringBuffer.append(TEXT_167);
        for (INode sqlDbComponent : sqlDbComponentsList) { 
    stringBuffer.append(TEXT_168);
    stringBuffer.append(sqlDbComponent.getUniqueName() );
    stringBuffer.append(TEXT_169);
        } 
    stringBuffer.append(TEXT_170);
      } 
    stringBuffer.append(TEXT_171);
    
        for (INode momNode : momComponentsList) {

    stringBuffer.append(TEXT_172);
    stringBuffer.append(momNode.getUniqueName() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(momNode.getUniqueName() );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(momNode.getUniqueName() );
    stringBuffer.append(TEXT_175);
    stringBuffer.append(momNode.getUniqueName() );
    stringBuffer.append(TEXT_176);
    
        }

    
        for (INode scpNode : scpComponentsList) {

    stringBuffer.append(TEXT_177);
    stringBuffer.append(scpNode.getUniqueName() );
    stringBuffer.append(TEXT_178);
    stringBuffer.append(scpNode.getUniqueName() );
    stringBuffer.append(TEXT_179);
    
        }

    
        for (INode sqlDbNode : sqlDbComponentsList) {

    stringBuffer.append(TEXT_180);
    stringBuffer.append(sqlDbNode.getUniqueName() );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(sqlDbNode.getUniqueName() );
    stringBuffer.append(TEXT_182);
    
        }

    stringBuffer.append(TEXT_183);
    return stringBuffer.toString();
  }
}