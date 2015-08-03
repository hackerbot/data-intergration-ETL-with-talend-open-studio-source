package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TFileOutputLDIFMainJava
{
  protected static String nl;
  public static synchronized TFileOutputLDIFMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputLDIFMainJava result = new TFileOutputLDIFMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_3 = " - Retrieving records from the datasource.\");" + NL + "\t\t\t";
  protected final String TEXT_4 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_5 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_6 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_8 = " - Retrieved records count: \"+ globalMap.get(\"";
  protected final String TEXT_9 = "_NB_LINE\") + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_10 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_11 = " - Retrieved records count: \"+ nb_line_";
  protected final String TEXT_12 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_14 = " - Written records count: \" + nb_line_";
  protected final String TEXT_15 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\tfinal StringBuffer log4jSb_";
  protected final String TEXT_17 = " = new StringBuffer();" + NL + "\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_19 = " - Retrieving the record \" + (nb_line_";
  protected final String TEXT_20 = ") + \".\");" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_22 = " - Writing the record \" + nb_line_";
  protected final String TEXT_23 = " + \" to the file.\");" + NL + "\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tlog.debug(\"";
  protected final String TEXT_25 = " - Processing the record \" + nb_line_";
  protected final String TEXT_26 = " + \".\");" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t\t\tlog.info(\"";
  protected final String TEXT_28 = " - Processed records count: \" + nb_line_";
  protected final String TEXT_29 = " + \" .\");" + NL + "\t\t\t";
  protected final String TEXT_30 = NL;
  protected final String TEXT_31 = NL + "\t\t//////////////////////////" + NL + "\t\tboolean encodingBase64_";
  protected final String TEXT_32 = " = false;";
  protected final String TEXT_33 = NL + "\t\tStringBuilder sb_";
  protected final String TEXT_34 = " = new StringBuilder();" + NL + "\t\tboolean needSeparator_";
  protected final String TEXT_35 = " = false;" + NL + "\t\tboolean canOutput_";
  protected final String TEXT_36 = " = false;" + NL + "\t\tboolean isPrintable_";
  protected final String TEXT_37 = " = false;";
  protected final String TEXT_38 = NL + "\t\tencodingBase64_";
  protected final String TEXT_39 = " = false;" + NL + "\t\tString value_";
  protected final String TEXT_40 = "_";
  protected final String TEXT_41 = " = \"\";" + NL + "\t\t";
  protected final String TEXT_42 = NL + "\t\t\tif(needSeparator_";
  protected final String TEXT_43 = "){" + NL + "\t\t\t\tsb_";
  protected final String TEXT_44 = ".append(\"-\\n\");" + NL + "\t\t\t\tneedSeparator_";
  protected final String TEXT_45 = " = false;" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_46 = NL + "\t    if(";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = " != null && !(\"\").equals(";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = ")) {";
  protected final String TEXT_51 = NL + "    \tvalue_";
  protected final String TEXT_52 = "_";
  protected final String TEXT_53 = " =";
  protected final String TEXT_54 = NL + "\t\tFormatterUtils.format_Date(";
  protected final String TEXT_55 = ".";
  protected final String TEXT_56 = ", ";
  protected final String TEXT_57 = ");";
  protected final String TEXT_58 = NL + "\t\t";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = ";";
  protected final String TEXT_61 = NL + "\t\tString.valueOf(";
  protected final String TEXT_62 = ");";
  protected final String TEXT_63 = NL + "\t\torg.apache.commons.codec.binary.Base64.encodeBase64String(";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = ");";
  protected final String TEXT_66 = NL + "\t\tString.valueOf(";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = ");";
  protected final String TEXT_69 = NL + "\t\tutil_";
  protected final String TEXT_70 = ".breakString(sb_";
  protected final String TEXT_71 = ", dn_";
  protected final String TEXT_72 = " + value_";
  protected final String TEXT_73 = "_";
  protected final String TEXT_74 = ", wrap_";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "        util_";
  protected final String TEXT_77 = ".breakString(sb_";
  protected final String TEXT_78 = ", changetype_";
  protected final String TEXT_79 = " + \"";
  protected final String TEXT_80 = "\", wrap_";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL;
  protected final String TEXT_83 = NL + "\tcanOutput_";
  protected final String TEXT_84 = " = true;";
  protected final String TEXT_85 = NL;
  protected final String TEXT_86 = NL + "\t    }  ";
  protected final String TEXT_87 = NL + "\t    }";
  protected final String TEXT_88 = NL + "//////////////////////////////////////////////////" + NL + "Please check \"isBase64\" for column ";
  protected final String TEXT_89 = " when \"isBianry\" is checked." + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_90 = NL + "\t\t\t\t\t\t// Convert binary or Base64 value to Base64 encoded string" + NL + "\t\t\t\t\t\tencodingBase64_";
  protected final String TEXT_91 = " = true;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_92 = NL;
  protected final String TEXT_93 = NL + "\tutil_";
  protected final String TEXT_94 = ".breakString(sb_";
  protected final String TEXT_95 = ", \"";
  protected final String TEXT_96 = ": \" + \"";
  protected final String TEXT_97 = "\", wrap_";
  protected final String TEXT_98 = ");" + NL + "\t";
  protected final String TEXT_99 = NL + "\t\tString[] values_";
  protected final String TEXT_100 = "_";
  protected final String TEXT_101 = " = value_";
  protected final String TEXT_102 = "_";
  protected final String TEXT_103 = ".split(";
  protected final String TEXT_104 = ");" + NL + "\t\tfor(String item_";
  protected final String TEXT_105 = " : values_";
  protected final String TEXT_106 = "_";
  protected final String TEXT_107 = "){" + NL + "\t\t\t// follow LDIF rules or not";
  protected final String TEXT_108 = NL + "               \t\t   isPrintable_";
  protected final String TEXT_109 = " = !(util_";
  protected final String TEXT_110 = ".needEncodeBase64(item_";
  protected final String TEXT_111 = "));" + NL + "               \t\t";
  protected final String TEXT_112 = NL + "               \t\t   isPrintable_";
  protected final String TEXT_113 = " =  netscape.ldap.util.LDIF.isPrintable(item_";
  protected final String TEXT_114 = ".getBytes(";
  protected final String TEXT_115 = "));" + NL + "               \t\t";
  protected final String TEXT_116 = NL + "\t\t\t\t// If content doesn't follow LDIF rules, it must be base64 encoded" + NL + "\t\t\t\tif(!isPrintable_";
  protected final String TEXT_117 = "){" + NL + "\t\t\t\t\tencodingBase64_";
  protected final String TEXT_118 = " = true;" + NL + "\t\t\t\t}" + NL + "\t\t\t\telse{" + NL + "\t\t\t\t\tencodingBase64_";
  protected final String TEXT_119 = " = false;" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t// Add \":\" to comply with base64 ldif syntax" + NL + "\t\t\t\titem_";
  protected final String TEXT_121 = " = util_";
  protected final String TEXT_122 = ".getBase64StringOrNot(encodingBase64_";
  protected final String TEXT_123 = ",item_";
  protected final String TEXT_124 = ",";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + "\t\t\t\t    util_";
  protected final String TEXT_127 = ".breakString(sb_";
  protected final String TEXT_128 = ", \"";
  protected final String TEXT_129 = ";binary";
  protected final String TEXT_130 = ":: \" + item_";
  protected final String TEXT_131 = ", wrap_";
  protected final String TEXT_132 = ");";
  protected final String TEXT_133 = NL + "\t\t\t\t\t\tif(!isPrintable_";
  protected final String TEXT_134 = "){" + NL + "\t\t\t\t\t\t\tutil_";
  protected final String TEXT_135 = ".breakString(sb_";
  protected final String TEXT_136 = ", \"";
  protected final String TEXT_137 = ":: \" + item_";
  protected final String TEXT_138 = ", wrap_";
  protected final String TEXT_139 = ");" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tutil_";
  protected final String TEXT_140 = ".breakString(sb_";
  protected final String TEXT_141 = ", \"";
  protected final String TEXT_142 = ": \" + item_";
  protected final String TEXT_143 = ", wrap_";
  protected final String TEXT_144 = ");" + NL + "\t               \t\t}";
  protected final String TEXT_145 = NL + "\t\t\t\t\t        \tutil_";
  protected final String TEXT_146 = ".breakString(sb_";
  protected final String TEXT_147 = ", \"";
  protected final String TEXT_148 = ": \" + item_";
  protected final String TEXT_149 = ", wrap_";
  protected final String TEXT_150 = ");" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_151 = NL + "\t\t\t\t\t   \t\t\tif(encodingBase64_";
  protected final String TEXT_152 = " && !isPrintable_";
  protected final String TEXT_153 = "){" + NL + "\t\t\t\t\t   \t\t\t\t util_";
  protected final String TEXT_154 = ".breakString(sb_";
  protected final String TEXT_155 = ", \"";
  protected final String TEXT_156 = ":: \" + item_";
  protected final String TEXT_157 = ", wrap_";
  protected final String TEXT_158 = ");" + NL + "\t\t\t\t\t   \t\t\t}else{" + NL + "\t\t\t\t\t   \t\t\t\t util_";
  protected final String TEXT_159 = ".breakString(sb_";
  protected final String TEXT_160 = ", \"";
  protected final String TEXT_161 = ": \" + item_";
  protected final String TEXT_162 = ", wrap_";
  protected final String TEXT_163 = ");" + NL + "\t\t\t\t\t   \t\t\t}" + NL + "\t\t\t\t\t   \t\t";
  protected final String TEXT_164 = NL + "\t\t}";
  protected final String TEXT_165 = NL + "\t\t// follow LDIF rules or not" + NL + "\t\t";
  protected final String TEXT_166 = NL + "\t\t   \t\t   isPrintable_";
  protected final String TEXT_167 = " = !(util_";
  protected final String TEXT_168 = ".needEncodeBase64(value_";
  protected final String TEXT_169 = "_";
  protected final String TEXT_170 = "));" + NL + "\t\t   \t\t";
  protected final String TEXT_171 = NL + "\t\t   \t\t   isPrintable_";
  protected final String TEXT_172 = " =  netscape.ldap.util.LDIF.isPrintable(value_";
  protected final String TEXT_173 = "_";
  protected final String TEXT_174 = ".getBytes(";
  protected final String TEXT_175 = "));" + NL + "\t\t   \t\t";
  protected final String TEXT_176 = NL + "\t\t\t// If content doesn't follow LDIF rules, it must be base64 encoded" + NL + "\t\t\tif(!isPrintable_";
  protected final String TEXT_177 = "){" + NL + "\t\t\t\tencodingBase64_";
  protected final String TEXT_178 = " = true;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_179 = NL + "\t\t// Add \":\" to comply with base64 ldif syntax" + NL + "\t\t\tvalue_";
  protected final String TEXT_180 = "_";
  protected final String TEXT_181 = " = util_";
  protected final String TEXT_182 = ".getBase64StringOrNot(encodingBase64_";
  protected final String TEXT_183 = ",value_";
  protected final String TEXT_184 = "_";
  protected final String TEXT_185 = ",";
  protected final String TEXT_186 = ");";
  protected final String TEXT_187 = NL + "                    util_";
  protected final String TEXT_188 = ".breakString(sb_";
  protected final String TEXT_189 = ", \"";
  protected final String TEXT_190 = ";binary";
  protected final String TEXT_191 = ":: \" + value_";
  protected final String TEXT_192 = "_";
  protected final String TEXT_193 = ", wrap_";
  protected final String TEXT_194 = ");";
  protected final String TEXT_195 = NL + "                        if(!isPrintable_";
  protected final String TEXT_196 = "){" + NL + "\t\t\t\t\t\t\tutil_";
  protected final String TEXT_197 = ".breakString(sb_";
  protected final String TEXT_198 = ", \"";
  protected final String TEXT_199 = ":: \" + value_";
  protected final String TEXT_200 = "_";
  protected final String TEXT_201 = ", wrap_";
  protected final String TEXT_202 = ");" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tutil_";
  protected final String TEXT_203 = ".breakString(sb_";
  protected final String TEXT_204 = ", \"";
  protected final String TEXT_205 = ": \" + value_";
  protected final String TEXT_206 = "_";
  protected final String TEXT_207 = ", wrap_";
  protected final String TEXT_208 = ");" + NL + "\t               \t\t}";
  protected final String TEXT_209 = NL + "\t\t\t\t\t\t        \tutil_";
  protected final String TEXT_210 = ".breakString(sb_";
  protected final String TEXT_211 = ", \"";
  protected final String TEXT_212 = ": \" + value_";
  protected final String TEXT_213 = "_";
  protected final String TEXT_214 = ", wrap_";
  protected final String TEXT_215 = ");" + NL + "\t\t\t\t\t\t        ";
  protected final String TEXT_216 = NL + "\t\t\t\t\t\t   \t\t\tif(encodingBase64_";
  protected final String TEXT_217 = " && !isPrintable_";
  protected final String TEXT_218 = "){" + NL + "\t\t\t\t\t\t   \t\t\t\t util_";
  protected final String TEXT_219 = ".breakString(sb_";
  protected final String TEXT_220 = ", \"";
  protected final String TEXT_221 = ":: \" + value_";
  protected final String TEXT_222 = "_";
  protected final String TEXT_223 = ", wrap_";
  protected final String TEXT_224 = ");" + NL + "\t\t\t\t\t\t   \t\t\t}else{" + NL + "\t\t\t\t\t\t   \t\t\t\t util_";
  protected final String TEXT_225 = ".breakString(sb_";
  protected final String TEXT_226 = ", \"";
  protected final String TEXT_227 = ": \" + value_";
  protected final String TEXT_228 = "_";
  protected final String TEXT_229 = ", wrap_";
  protected final String TEXT_230 = ");" + NL + "\t\t\t\t\t\t   \t\t\t}" + NL + "\t\t\t\t\t\t   \t\t";
  protected final String TEXT_231 = NL + "\tneedSeparator_";
  protected final String TEXT_232 = " = true;" + NL + "\tcanOutput_";
  protected final String TEXT_233 = " = true;";
  protected final String TEXT_234 = NL + "sb_";
  protected final String TEXT_235 = ".append(\"-\\n\");";
  protected final String TEXT_236 = NL + "//////////////////////////////////////////////////" + NL + "Please check \"isBase64\" for column ";
  protected final String TEXT_237 = " when \"isBianry\" is checked." + NL + "//////////////////////////////////////////////////";
  protected final String TEXT_238 = NL + "\t\t\t\t\t\t// Convert binary or Base64 value to Base64 encoded string" + NL + "\t\t\t\t\t\tencodingBase64_";
  protected final String TEXT_239 = " = true;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_240 = NL + "\t";
  protected final String TEXT_241 = NL + "\t\tString[] values_";
  protected final String TEXT_242 = "_";
  protected final String TEXT_243 = " = value_";
  protected final String TEXT_244 = "_";
  protected final String TEXT_245 = ".split(";
  protected final String TEXT_246 = ");" + NL + "\t\tfor(String item_";
  protected final String TEXT_247 = " : values_";
  protected final String TEXT_248 = "_";
  protected final String TEXT_249 = "){" + NL + "\t\t        //follow LDIF rules or not" + NL + "\t\t        ";
  protected final String TEXT_250 = NL + "\t\t           \t\t   isPrintable_";
  protected final String TEXT_251 = " = !(util_";
  protected final String TEXT_252 = ".needEncodeBase64(item_";
  protected final String TEXT_253 = "));" + NL + "\t\t           \t\t";
  protected final String TEXT_254 = NL + "\t\t           \t\t   isPrintable_";
  protected final String TEXT_255 = " =  netscape.ldap.util.LDIF.isPrintable(item_";
  protected final String TEXT_256 = ".getBytes(";
  protected final String TEXT_257 = "));" + NL + "\t\t           \t\t";
  protected final String TEXT_258 = NL + "\t\t\t\t\t// If content doesn't follow LDIF rules, it must be base64 encoded" + NL + "\t\t\t\t\tif(!isPrintable_";
  protected final String TEXT_259 = "){" + NL + "\t\t\t\t\t\tencodingBase64_";
  protected final String TEXT_260 = " = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\telse{" + NL + "\t\t\t\t\t\tencodingBase64_";
  protected final String TEXT_261 = " = false;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_262 = NL + "\t\t\t\t// Add \":\" to comply with base64 ldif syntax" + NL + "\t                item_";
  protected final String TEXT_263 = " = util_";
  protected final String TEXT_264 = ".getBase64StringOrNot(encodingBase64_";
  protected final String TEXT_265 = ",item_";
  protected final String TEXT_266 = ",";
  protected final String TEXT_267 = ");";
  protected final String TEXT_268 = NL + "\t\t\t\t\t\tutil_";
  protected final String TEXT_269 = ".breakString(sb_";
  protected final String TEXT_270 = ", \"";
  protected final String TEXT_271 = ";binary";
  protected final String TEXT_272 = ":: \" + item_";
  protected final String TEXT_273 = ", wrap_";
  protected final String TEXT_274 = ");";
  protected final String TEXT_275 = NL + "                            if(!isPrintable_";
  protected final String TEXT_276 = "){" + NL + "    \t\t\t\t\t\t\tutil_";
  protected final String TEXT_277 = ".breakString(sb_";
  protected final String TEXT_278 = ", \"";
  protected final String TEXT_279 = ":: \" + item_";
  protected final String TEXT_280 = ", wrap_";
  protected final String TEXT_281 = ");" + NL + "    \t\t\t\t\t\t}else{" + NL + "    \t\t\t\t\t\t\tutil_";
  protected final String TEXT_282 = ".breakString(sb_";
  protected final String TEXT_283 = ", \"";
  protected final String TEXT_284 = ": \" + item_";
  protected final String TEXT_285 = ", wrap_";
  protected final String TEXT_286 = ");" + NL + "    \t               \t\t}";
  protected final String TEXT_287 = NL + "\t\t\t\t\t\t\t        \tutil_";
  protected final String TEXT_288 = ".breakString(sb_";
  protected final String TEXT_289 = ", \"";
  protected final String TEXT_290 = ": \" + item_";
  protected final String TEXT_291 = ", wrap_";
  protected final String TEXT_292 = ");" + NL + "\t\t\t\t\t\t\t        ";
  protected final String TEXT_293 = NL + "\t\t\t\t\t\t\t   \t\t\tif(encodingBase64_";
  protected final String TEXT_294 = " && !isPrintable_";
  protected final String TEXT_295 = "){" + NL + "\t\t\t\t\t\t\t   \t\t\t\t util_";
  protected final String TEXT_296 = ".breakString(sb_";
  protected final String TEXT_297 = ", \"";
  protected final String TEXT_298 = ":: \" + item_";
  protected final String TEXT_299 = ", wrap_";
  protected final String TEXT_300 = ");" + NL + "\t\t\t\t\t\t\t   \t\t\t}else{" + NL + "\t\t\t\t\t\t\t   \t\t\t\t util_";
  protected final String TEXT_301 = ".breakString(sb_";
  protected final String TEXT_302 = ", \"";
  protected final String TEXT_303 = ": \" + item_";
  protected final String TEXT_304 = ", wrap_";
  protected final String TEXT_305 = ");" + NL + "\t\t\t\t\t\t\t   \t\t\t}" + NL + "\t\t\t\t\t\t\t   \t\t";
  protected final String TEXT_306 = NL + "\t\t}";
  protected final String TEXT_307 = NL + "                // follow LDIF rules or not";
  protected final String TEXT_308 = NL + "                   \t\t   isPrintable_";
  protected final String TEXT_309 = " = !(util_";
  protected final String TEXT_310 = ".needEncodeBase64(value_";
  protected final String TEXT_311 = "_";
  protected final String TEXT_312 = "));" + NL + "                   \t\t";
  protected final String TEXT_313 = NL + "                   \t\t   isPrintable_";
  protected final String TEXT_314 = " =  netscape.ldap.util.LDIF.isPrintable(value_";
  protected final String TEXT_315 = "_";
  protected final String TEXT_316 = ".getBytes(";
  protected final String TEXT_317 = "));" + NL + "                   \t\t";
  protected final String TEXT_318 = NL + "\t\t\t\t\t// If content doesn't follow LDIF rules, it must be base64 encoded" + NL + "\t\t\t\t\tif(!isPrintable_";
  protected final String TEXT_319 = "){" + NL + "\t\t\t\t\t\tencodingBase64_";
  protected final String TEXT_320 = " = true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_321 = NL + "\t\t\t// Add \":\" to comply with base64 ldif syntax" + NL + "\t\t\t\tvalue_";
  protected final String TEXT_322 = "_";
  protected final String TEXT_323 = " = util_";
  protected final String TEXT_324 = ".getBase64StringOrNot(encodingBase64_";
  protected final String TEXT_325 = ",value_";
  protected final String TEXT_326 = "_";
  protected final String TEXT_327 = ",";
  protected final String TEXT_328 = ");";
  protected final String TEXT_329 = NL + "                    util_";
  protected final String TEXT_330 = ".breakString(sb_";
  protected final String TEXT_331 = ", \"";
  protected final String TEXT_332 = ";binary";
  protected final String TEXT_333 = ":: \" + value_";
  protected final String TEXT_334 = "_";
  protected final String TEXT_335 = ", wrap_";
  protected final String TEXT_336 = ");";
  protected final String TEXT_337 = NL + "                        if(!isPrintable_";
  protected final String TEXT_338 = "){" + NL + "\t\t\t\t\t\t\tutil_";
  protected final String TEXT_339 = ".breakString(sb_";
  protected final String TEXT_340 = ", \"";
  protected final String TEXT_341 = ":: \" + value_";
  protected final String TEXT_342 = "_";
  protected final String TEXT_343 = ", wrap_";
  protected final String TEXT_344 = ");" + NL + "\t\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t\tutil_";
  protected final String TEXT_345 = ".breakString(sb_";
  protected final String TEXT_346 = ", \"";
  protected final String TEXT_347 = ": \" + value_";
  protected final String TEXT_348 = "_";
  protected final String TEXT_349 = ", wrap_";
  protected final String TEXT_350 = ");" + NL + "\t               \t\t}";
  protected final String TEXT_351 = NL + "\t\t\t\t\t\t        \tutil_";
  protected final String TEXT_352 = ".breakString(sb_";
  protected final String TEXT_353 = ", \"";
  protected final String TEXT_354 = ": \" + value_";
  protected final String TEXT_355 = "_";
  protected final String TEXT_356 = ", wrap_";
  protected final String TEXT_357 = ");" + NL + "\t\t\t\t\t\t        ";
  protected final String TEXT_358 = NL + "\t\t\t\t\t\t   \t\t\tif(encodingBase64_";
  protected final String TEXT_359 = " && !isPrintable_";
  protected final String TEXT_360 = "){" + NL + "\t\t\t\t\t\t   \t\t\t\t util_";
  protected final String TEXT_361 = ".breakString(sb_";
  protected final String TEXT_362 = ", \"";
  protected final String TEXT_363 = ":: \" + value_";
  protected final String TEXT_364 = "_";
  protected final String TEXT_365 = ", wrap_";
  protected final String TEXT_366 = ");" + NL + "\t\t\t\t\t\t   \t\t\t}else{" + NL + "\t\t\t\t\t\t   \t\t\t\t util_";
  protected final String TEXT_367 = ".breakString(sb_";
  protected final String TEXT_368 = ", \"";
  protected final String TEXT_369 = ": \" + value_";
  protected final String TEXT_370 = "_";
  protected final String TEXT_371 = ", wrap_";
  protected final String TEXT_372 = ");" + NL + "\t\t\t\t\t\t   \t\t\t}" + NL + "\t\t\t\t\t\t   \t\t";
  protected final String TEXT_373 = NL + "\t\tcanOutput_";
  protected final String TEXT_374 = " = true;";
  protected final String TEXT_375 = NL + "\t\tutil_";
  protected final String TEXT_376 = ".breakString(sb_";
  protected final String TEXT_377 = ", \"";
  protected final String TEXT_378 = ": \" + value_";
  protected final String TEXT_379 = "_";
  protected final String TEXT_380 = ", wrap_";
  protected final String TEXT_381 = ");" + NL + "\t\tcanOutput_";
  protected final String TEXT_382 = " = true;";
  protected final String TEXT_383 = NL;
  protected final String TEXT_384 = NL + "\t    }";
  protected final String TEXT_385 = NL + "\t\tsb_";
  protected final String TEXT_386 = ".append('\\n');" + NL + "" + NL + "\tif(canOutput_";
  protected final String TEXT_387 = "){" + NL + "\t\tpw_";
  protected final String TEXT_388 = ".write(sb_";
  protected final String TEXT_389 = ".toString());" + NL + "\t\t";
  protected final String TEXT_390 = NL + "            if(nb_line_";
  protected final String TEXT_391 = "%";
  protected final String TEXT_392 = " == 0) {" + NL + "    \t\tpw_";
  protected final String TEXT_393 = ".flush();" + NL + "    \t\t}" + NL + "\t\t";
  protected final String TEXT_394 = NL + NL + "    \tnb_line_";
  protected final String TEXT_395 = "++;" + NL + "    }";
  protected final String TEXT_396 = NL + "    \t//////////////////////////";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	//this util class use by set log4j debug paramters
	class DefaultLog4jFileUtil {
	
		INode node = null;
	    String cid = null;
 		boolean isLog4jEnabled = false;
 		String label = null;
 		
 		public DefaultLog4jFileUtil(){
 		}
 		public DefaultLog4jFileUtil(INode node) {
 			this.node = node;
 			this.cid = node.getUniqueName();
 			this.label = cid;
			this.isLog4jEnabled = ("true").equals(org.talend.core.model.process.ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));
 		}
 		
 		public void setCid(String cid) {
 			this.cid = cid;
 		}
 		
		//for all tFileinput* components 
		public void startRetriveDataInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_2);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_3);
    
			}
		}
		
		public void retrievedDataNumberInfo() {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_4);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
			}
		}
		
		public void retrievedDataNumberInfoFromGlobalMap(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_7);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    
			}
		}
		
		//for all tFileinput* components 
		public void retrievedDataNumberInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_10);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    
			}
		}
		
		public void writeDataFinishInfo(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    
			}
		}
		
 		//TODO delete it and remove all log4jSb parameter from components
		public void componentStartInfo(INode node) {
			if (isLog4jEnabled) {
			
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node,boolean hasIncreased) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(hasIncreased?"":"+1");
    stringBuffer.append(TEXT_20);
    
			}
		}
		
		//TODO rename or delete it
		public void debugRetriveData(INode node) {
			debugRetriveData(node,true);
		}
		
		//TODO rename or delete it
		public void debugWriteData(INode node) {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    
			}
		}
		
		public void logCurrentRowNumberInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    
			}
		}
		
		public void logDataCountInfo() {
			if(isLog4jEnabled){
			
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    
			}
		}
	}
	
	final DefaultLog4jFileUtil log4jFileUtil = new DefaultLog4jFileUtil((INode)(((org.talend.designer.codegen.config.CodeGeneratorArgument)argument).getArgument()));
	
    stringBuffer.append(TEXT_30);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
boolean willValidateDN = "true".equals(ElementParameterParser.getValue(node,"__VALIDATE_DISTINGUISHED_NAME__"));

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        String cid = node.getUniqueName();
        String changetype = ElementParameterParser.getValue(node, "__CHANGETYPE__");
        boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
        String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");

        List<Map<String, String>> multiValueColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MULTIVALUECOLUMNS__");
        List<Map<String, String>> modifyColumns = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__MODIFYCONFIG__");

    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
    	List<? extends IConnection> conns = node.getIncomingConnections();
    	for (IConnection conn : conns) {
    		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
    			boolean generateOneAlready = false; //only for Modify append the char '-'
    			List<IMetadataColumn> columns = metadata.getListColumns();
    			int sizeColumns = columns.size();
    			boolean firstLoop = true;
    			for (int i = 0; i < sizeColumns; i++) {
    				IMetadataColumn column = columns.get(i);
					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    //For bug TDI-26863
		String modify_operation = null;
		for(Map<String, String> line:modifyColumns){
			String columnName = line.get("SCHEMA_COLUMN");
			if(column.getLabel().equals(columnName)){
				modify_operation = line.get("OPERATION");
				break;
			}
		}
		if(i > 1 && "modify".equals(changetype) && !("none".equals(modify_operation))) {
		
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_45);
    
		}
					if(!isPrimitive) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_50);
    
} // closure for if(!isPrimitive) Line: 76

    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    
    				String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    				if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {

    stringBuffer.append(TEXT_54);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_57);
    
					} else if(javaType == JavaTypesManager.STRING) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_60);
    
					} else if (javaType == JavaTypesManager.BIGDECIMAL) {

    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_62);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) {

    stringBuffer.append(TEXT_63);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_65);
    
					} else {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_68);
    
					}
	if(i==0) {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    if(!"none".equals(changetype)){
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(changetype );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_81);
    }
    stringBuffer.append(TEXT_82);
    if("delete".equals(changetype)){
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    
	if(!isPrimitive) {

    stringBuffer.append(TEXT_86);
     /* closure for Line: 78 */ 
    
	} // closure for if(!isPrimitive) Line: 118
	continue;
 } //Line:52 "for (int i = 0; i < sizeColumns; i++)"
if ("delete".equals(changetype)) {
	if(firstLoop){
	if(!isPrimitive) {

    stringBuffer.append(TEXT_87);
    
	}
	}
	firstLoop = false;
	break;
}
if ("modify".equals(changetype)) {
		String operation = null;
		boolean isMultiValue = false;
		String separator = null;
		boolean isBinary = false;
		boolean isBase64 = false;
		for(Map<String, String> line:modifyColumns){// search in the configuration table
				String columnName = line.get("SCHEMA_COLUMN");
				if(column.getLabel().equals(columnName)){
					operation = line.get("OPERATION");
					isMultiValue = "true".equals(line.get("ISMULTIVALUE"));
					separator = line.get("SEPARATOR");
					isBinary = "true".equals(line.get("BINARY"));
					isBase64 = "true".equals(line.get("BASE64"));
					// Binary content --> always Base64 encoded
					// Explicit base64 encoding : base64 checkbox checked for this column
					if(isBinary && !isBase64){

    stringBuffer.append(TEXT_88);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_89);
    
					}
					if(isBinary || isBase64){
						
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    
					}
					break;
				}
		}

    stringBuffer.append(TEXT_92);
    if(!"none".equals(operation)){
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(operation );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_98);
    if(isMultiValue){
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(separator );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    
               if(willValidateDN){
               		
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    
               }else{
               		
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_115);
    
               }
			// Not binary and no explicit base64 encoding --> check if base 64 encoding needed
			if(!isBinary && !isBase64){
				
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_119);
    
			}
			
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_125);
    
			List<IMetadataColumn> columns_sub = metadata.getListColumns();
            for (int j = 0; j < columns_sub.size(); j++) {
                IMetadataColumn column_sub = columns_sub.get(j);
                JavaType javaType_sub = JavaTypesManager.getJavaTypeFromId(column_sub.getTalendType());
                if(javaType_sub == JavaTypesManager.BYTE_ARRAY && column_sub.getLabel().equals(column.getLabel())){

    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(column.getLabel() );
    if(isBinary){
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_132);
    
                }else if(column_sub.getLabel().equals(column.getLabel())){
					if(isBase64){

    stringBuffer.append(TEXT_133);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_136);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_139);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_141);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_144);
    
					}else{
					   if(!willValidateDN){
					        
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_146);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_147);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_150);
    
					   }else{
					   		
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_158);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_160);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    
					   }
				   }
                }
            }

    stringBuffer.append(TEXT_164);
    
	}else{

    stringBuffer.append(TEXT_165);
    
		   if(willValidateDN){
		   		
    stringBuffer.append(TEXT_166);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_168);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_170);
    
		   }else{
		   		
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_172);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_174);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_175);
    
		   }
		// Not binary and no explicit base64 encoding --> check if base 64 encoding needed
		if(!isBinary && !isBase64){

    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    
		}
		
    stringBuffer.append(TEXT_179);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_185);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_186);
    
			List<IMetadataColumn> columns_sub = metadata.getListColumns();
            for (int j = 0; j < columns_sub.size(); j++) {
                IMetadataColumn column_sub = columns_sub.get(j);
                JavaType javaType_sub = JavaTypesManager.getJavaTypeFromId(column_sub.getTalendType());
                if(javaType_sub == JavaTypesManager.BYTE_ARRAY && column_sub.getLabel().equals(column.getLabel())){

    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(column.getLabel() );
    if(isBinary){
    stringBuffer.append(TEXT_190);
    }
    stringBuffer.append(TEXT_191);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_194);
    
                }else if(column_sub.getLabel().equals(column.getLabel())){
					if(isBase64){

    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_197);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_198);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_199);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_204);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_205);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_208);
    
					}else{
						   if(!willValidateDN){
						        
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_211);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_212);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_214);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_215);
    
						   }else{
						   		
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_221);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_223);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_227);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_229);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_230);
    
						   }
					}
                }
            }
	}

    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_233);
    }
  if(i==sizeColumns - 1){

    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_235);
    }
}// here end the if modify

     if ("add".equals(changetype) || "none".equals(changetype)) {
		boolean isMultiValue = false;
		String separator = null;
		boolean isBinary = false;
		boolean isBase64 = false;
		for(Map<String, String> line:multiValueColumns){// search in the configuration table
				String columnName = line.get("SCHEMA_COLUMN");
				if(column.getLabel().equals(columnName)){
					isMultiValue = "true".equals(line.get("ISMULTIVALUE"));
					separator = line.get("SEPARATOR");
					isBinary = "true".equals(line.get("BINARY"));
					isBase64 = "true".equals(line.get("BASE64"));
					// Binary content --> always Base64 encoded
					// Explicit base64 encoding : base64 checkbox checked for this column
                    if(isBinary && !isBase64){

    stringBuffer.append(TEXT_236);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_237);
    
                    }
					if(isBinary || isBase64){
						
    stringBuffer.append(TEXT_238);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_239);
    
					}
					break;
				}
		}

    stringBuffer.append(TEXT_240);
    if(isMultiValue){
    stringBuffer.append(TEXT_241);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_243);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_245);
    stringBuffer.append(separator );
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_247);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    
		           if(willValidateDN){
		           		
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_253);
    
		           }else{
		           		
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_256);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_257);
    
		           }
				// Not binary and no explicit base64 encoding --> check if base 64 encoding needed
				if(!isBinary && !isBase64){
					
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_259);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    
				}
				
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_263);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_266);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_267);
    
    			List<IMetadataColumn> columns_sub = metadata.getListColumns();
                for (int j = 0; j < columns_sub.size(); j++) {
                    IMetadataColumn column_sub = columns_sub.get(j);
                    JavaType javaType_sub = JavaTypesManager.getJavaTypeFromId(column_sub.getTalendType());
                    if(javaType_sub == JavaTypesManager.BYTE_ARRAY && column_sub.getLabel().equals(column.getLabel())){

    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_270);
    stringBuffer.append(column.getLabel() );
    if(isBinary){
    stringBuffer.append(TEXT_271);
    }
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_274);
    
                    }else if(column_sub.getLabel().equals(column.getLabel())){
    					if(isBase64){

    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_276);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_278);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_282);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_283);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    
					   }else{
							   if(!willValidateDN){
							        
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_289);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_292);
    
							   }else{
							   		
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_297);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_302);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_305);
    
							   }
					   }
                    }
			     }

    stringBuffer.append(TEXT_306);
    
	}else{

    stringBuffer.append(TEXT_307);
    
                   if(willValidateDN){
                   		
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_310);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_312);
    
                   }else{
                   		
    stringBuffer.append(TEXT_313);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_314);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_315);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_316);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_317);
    
                   }
				// Not binary and no explicit base64 encoding --> check if base 64 encoding needed
				if(!isBinary && !isBase64){

    stringBuffer.append(TEXT_318);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    
				}
			
    stringBuffer.append(TEXT_321);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_323);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_327);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_328);
    
			List<IMetadataColumn> columns_sub = metadata.getListColumns();
            for (int j = 0; j < columns_sub.size(); j++) {
                IMetadataColumn column_sub = columns_sub.get(j);
                JavaType javaType_sub = JavaTypesManager.getJavaTypeFromId(column_sub.getTalendType());
                if(javaType_sub == JavaTypesManager.BYTE_ARRAY && column_sub.getLabel().equals(column.getLabel())){

    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_331);
    stringBuffer.append(column.getLabel() );
    if(isBinary){
    stringBuffer.append(TEXT_332);
    }
    stringBuffer.append(TEXT_333);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_336);
    
                }else if(column_sub.getLabel().equals(column.getLabel())){
					if(isBase64){

    stringBuffer.append(TEXT_337);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_338);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_339);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_340);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_341);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_342);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_343);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_344);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_345);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_346);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_347);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_348);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_349);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_350);
    
					}else{
						   if(!willValidateDN){
						        
    stringBuffer.append(TEXT_351);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_352);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_353);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_354);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_355);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_356);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_357);
    
						   }else{
						   		
    stringBuffer.append(TEXT_358);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_359);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_360);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_361);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_362);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_363);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_364);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_365);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_366);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_367);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_368);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_369);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_370);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_371);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_372);
    
						   }
					}
                }
            }
	}

    stringBuffer.append(TEXT_373);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_374);
    
}// here end the if add

     if ("modrdn".equals(changetype)) {

    stringBuffer.append(TEXT_375);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_376);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_377);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_378);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_379);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_380);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_381);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_382);
    
}// here end the if modrdn

    stringBuffer.append(TEXT_383);
    
	if(!isPrimitive) {

    stringBuffer.append(TEXT_384);
    
	}

    
}//here end the last for, the List "columns"

    stringBuffer.append(TEXT_385);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_386);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_387);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_388);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_389);
     if(flushOnRow) { 
    stringBuffer.append(TEXT_390);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_391);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_392);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_393);
    
			}
		
    stringBuffer.append(TEXT_394);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_395);
    
		log4jFileUtil.debugWriteData(node);
	}
}//here end the first for, the List "conns"

    stringBuffer.append(TEXT_396);
    
  }
}

    return stringBuffer.toString();
  }
}
