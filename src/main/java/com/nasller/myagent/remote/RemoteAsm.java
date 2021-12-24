package com.nasller.myagent.remote;

import com.janetfilter.core.models.FilterRule;
import jdk.internal.org.objectweb.asm.*;

import java.util.List;

import static jdk.internal.org.objectweb.asm.Opcodes.*;

public class RemoteAsm {

	public static void visitStartProcess(MethodVisitor methodVisitor,List<FilterRule> configList){
		methodVisitor.visitCode();
		Label label0 = new Label();
		Label label1 = new Label();
		Label label2 = new Label();
		methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/io/IOException");
		methodVisitor.visitTryCatchBlock(label0, label1, label2, "java/lang/InterruptedException");
		Label label3 = new Label();
		methodVisitor.visitLabel(label3);
		methodVisitor.visitLineNumber(89, label3);
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "createCommandLine", "()Lcom/intellij/execution/configurations/GeneralCommandLine;", false);
		methodVisitor.visitVarInsn(ASTORE, 1);
		Label label4 = new Label();
		methodVisitor.visitLabel(label4);
		methodVisitor.visitLineNumber(90, label4);
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "this$0", "Lcom/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile;");
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile", "myRemoteCredentials", "Lcom/intellij/remote/RemoteCredentials;");
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "val$project", "Lcom/intellij/openapi/project/Project;");
		methodVisitor.visitMethodInsn(INVOKESTATIC, "com/intellij/ssh/RemoteCredentialsUtil", "connectionBuilder", "(Lcom/intellij/remote/RemoteCredentials;Lcom/intellij/openapi/project/Project;)Lcom/intellij/ssh/ConnectionBuilder;", false);
		methodVisitor.visitVarInsn(ASTORE, 2);
		Label label5 = new Label();
		methodVisitor.visitLabel(label5);
		methodVisitor.visitLineNumber(91, label5);
		methodVisitor.visitTypeInsn(NEW, "com/intellij/remote/RemoteSdkCredentialsBuilder");
		methodVisitor.visitInsn(DUP);
		methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/intellij/remote/RemoteSdkCredentialsBuilder", "<init>", "()V", false);
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "this$0", "Lcom/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile;");
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile", "myRemoteCredentials", "Lcom/intellij/remote/RemoteCredentials;");
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/RemoteSdkCredentialsBuilder", "withCredentials", "(Lcom/intellij/remote/RemoteCredentials;)Lcom/intellij/remote/RemoteSdkCredentialsBuilder;", false);
		methodVisitor.visitLdcInsn("");
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/RemoteSdkCredentialsBuilder", "withInterpreterPath", "(Ljava/lang/String;)Lcom/intellij/remote/RemoteSdkCredentialsBuilder;", false);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/RemoteSdkCredentialsBuilder", "build", "()Lcom/intellij/remote/RemoteSdkCredentials;", false);
		methodVisitor.visitVarInsn(ASTORE, 3);
		Label label6 = new Label();
		methodVisitor.visitLabel(label6);
		methodVisitor.visitLineNumber(92, label6);
		methodVisitor.visitVarInsn(ALOAD, 2);
		methodVisitor.visitVarInsn(ALOAD, 1);
		methodVisitor.visitMethodInsn(INVOKESTATIC, "com/intellij/ssh/RemoteCredentialsUtil", "processBuilder", "(Lcom/intellij/ssh/ConnectionBuilder;Lcom/intellij/execution/configurations/GeneralCommandLine;)Lcom/intellij/ssh/ProcessBuilder;", false);
		methodVisitor.visitInsn(ICONST_1);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/ssh/ProcessBuilder", "withAllocatePty", "(Z)Lcom/intellij/ssh/ProcessBuilder;", false);
		methodVisitor.visitVarInsn(ASTORE, 4);
		Label label7 = new Label();
		methodVisitor.visitLabel(label7);
		methodVisitor.visitLineNumber(93, label7);
		methodVisitor.visitVarInsn(ALOAD, 4);
		methodVisitor.visitMethodInsn(INVOKESTATIC, "java/util/Objects", "requireNonNull", "(Ljava/lang/Object;)Ljava/lang/Object;", false);
		methodVisitor.visitInsn(POP);
		Label label8 = new Label();
		methodVisitor.visitLabel(label8);
		methodVisitor.visitLineNumber(94, label8);
		methodVisitor.visitTypeInsn(NEW, "com/intellij/remote/DeferredRemoteProcess");
		methodVisitor.visitInsn(DUP);
		methodVisitor.visitVarInsn(ALOAD, 4);
		methodVisitor.visitInsn(DUP);
		methodVisitor.visitMethodInsn(INVOKESTATIC, "java/util/Objects", "requireNonNull", "(Ljava/lang/Object;)Ljava/lang/Object;", false);
		methodVisitor.visitInsn(POP);
		methodVisitor.visitInvokeDynamicInsn("invoke", "(Lcom/intellij/ssh/ProcessBuilder;)Lkotlin/jvm/functions/Function0;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;"), Type.getType("()Ljava/lang/Object;"), new Handle(Opcodes.H_INVOKEVIRTUAL, "com/intellij/ssh/ProcessBuilder", "start", "()Lcom/intellij/ssh/process/SshExecProcess;"), Type.getType("()Lcom/intellij/remote/RemoteProcess;"));
		methodVisitor.visitMethodInsn(INVOKESTATIC, "org/jetbrains/concurrency/Promises", "runAsync", "(Lkotlin/jvm/functions/Function0;)Lorg/jetbrains/concurrency/Promise;", false);
		methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/intellij/remote/DeferredRemoteProcess", "<init>", "(Lorg/jetbrains/concurrency/Promise;)V", false);
		methodVisitor.visitVarInsn(ASTORE, 5);
		Label label9 = new Label();
		methodVisitor.visitLabel(label9);
		methodVisitor.visitLineNumber(95, label9);
		methodVisitor.visitVarInsn(ALOAD, 3);
		methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/intellij/remote/RemoteSdkCredentials", "getFullInterpreterPath", "()Ljava/lang/String;", true);
		methodVisitor.visitVarInsn(ASTORE, 6);
		Label label10 = new Label();
		methodVisitor.visitLabel(label10);
		methodVisitor.visitLineNumber(96, label10);
		methodVisitor.visitVarInsn(ALOAD, 1);
		methodVisitor.visitVarInsn(ALOAD, 6);
		methodVisitor.visitVarInsn(ALOAD, 1);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/execution/configurations/GeneralCommandLine", "getExePath", "()Ljava/lang/String;", false);
		methodVisitor.visitInvokeDynamicInsn("makeConcatWithConstants", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/StringConcatFactory", "makeConcatWithConstants", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;"), "\u0001:\u0001");
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/execution/configurations/GeneralCommandLine", "getCommandLineString", "(Ljava/lang/String;)Ljava/lang/String;", false);
		methodVisitor.visitVarInsn(ASTORE, 7);
		Label label11 = new Label();
		methodVisitor.visitLabel(label11);
		methodVisitor.visitLineNumber(98, label11);
		methodVisitor.visitVarInsn(ALOAD, 7);
		methodVisitor.visitLdcInsn(configList.get(0).getRule());
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "contains", "(Ljava/lang/CharSequence;)Z", false);
		Label label12 = new Label();
		methodVisitor.visitJumpInsn(IFEQ, label12);
		methodVisitor.visitLabel(label0);
		methodVisitor.visitLineNumber(100, label0);
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "this$0", "Lcom/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile;");
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile", "myTool", "Lcom/jetbrains/plugins/remotesdk/tools/RemoteTool;");
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/jetbrains/plugins/remotesdk/tools/RemoteTool", "getDescription", "()Ljava/lang/String;", false);
		methodVisitor.visitMethodInsn(INVOKESTATIC, "org/apache/commons/lang3/StringUtils", "isNotBlank", "(Ljava/lang/CharSequence;)Z", false);
		Label label13 = new Label();
		methodVisitor.visitJumpInsn(IFEQ, label13);
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "this$0", "Lcom/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile;");
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile", "myTool", "Lcom/jetbrains/plugins/remotesdk/tools/RemoteTool;");
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/jetbrains/plugins/remotesdk/tools/RemoteTool", "getDescription", "()Ljava/lang/String;", false);
		Label label14 = new Label();
		methodVisitor.visitJumpInsn(GOTO, label14);
		methodVisitor.visitLabel(label13);
		methodVisitor.visitLineNumber(101, label13);
		methodVisitor.visitFrame(Opcodes.F_NEW, 8, new Object[]{"com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "com/intellij/execution/configurations/GeneralCommandLine", "com/intellij/ssh/ConnectionBuilder", "com/intellij/remote/RemoteSdkCredentials", "com/intellij/ssh/ProcessBuilder", "com/intellij/remote/DeferredRemoteProcess", "java/lang/String", "java/lang/String"}, 0, new Object[]{});
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "this$0", "Lcom/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile;");
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile", "myTool", "Lcom/jetbrains/plugins/remotesdk/tools/RemoteTool;");
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/jetbrains/plugins/remotesdk/tools/RemoteTool", "getActionId", "()Ljava/lang/String;", false);
		methodVisitor.visitLdcInsn("pro");
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "contains", "(Ljava/lang/CharSequence;)Z", false);
		Label label15 = new Label();
		methodVisitor.visitJumpInsn(IFEQ, label15);
		methodVisitor.visitLdcInsn(configList.get(2).getRule());
		methodVisitor.visitJumpInsn(GOTO, label14);
		methodVisitor.visitLabel(label15);
		methodVisitor.visitFrame(Opcodes.F_NEW, 8, new Object[]{"com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "com/intellij/execution/configurations/GeneralCommandLine", "com/intellij/ssh/ConnectionBuilder", "com/intellij/remote/RemoteSdkCredentials", "com/intellij/ssh/ProcessBuilder", "com/intellij/remote/DeferredRemoteProcess", "java/lang/String", "java/lang/String"}, 0, new Object[]{});
		methodVisitor.visitLdcInsn(configList.get(3).getRule());
		methodVisitor.visitLabel(label14);
		methodVisitor.visitFrame(Opcodes.F_NEW, 8, new Object[]{"com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "com/intellij/execution/configurations/GeneralCommandLine", "com/intellij/ssh/ConnectionBuilder", "com/intellij/remote/RemoteSdkCredentials", "com/intellij/ssh/ProcessBuilder", "com/intellij/remote/DeferredRemoteProcess", "java/lang/String", "java/lang/String"}, 1, new Object[]{"java/lang/String"});
		methodVisitor.visitVarInsn(ASTORE, 9);
		Label label16 = new Label();
		methodVisitor.visitLabel(label16);
		methodVisitor.visitLineNumber(102, label16);
		methodVisitor.visitVarInsn(ALOAD, 5);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/RemoteProcess", "getOutputStream", "()Ljava/io/OutputStream;", false);
		methodVisitor.visitLdcInsn(configList.get(1).getRule());
		methodVisitor.visitFieldInsn(GETSTATIC, "java/nio/charset/StandardCharsets", "UTF_8", "Ljava/nio/charset/Charset;");
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "getBytes", "(Ljava/nio/charset/Charset;)[B", false);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/OutputStream", "write", "([B)V", false);
		Label label17 = new Label();
		methodVisitor.visitLabel(label17);
		methodVisitor.visitLineNumber(103, label17);
		methodVisitor.visitVarInsn(ALOAD, 5);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/RemoteProcess", "getOutputStream", "()Ljava/io/OutputStream;", false);
		methodVisitor.visitIntInsn(BIPUSH, 13);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/OutputStream", "write", "(I)V", false);
		Label label18 = new Label();
		methodVisitor.visitLabel(label18);
		methodVisitor.visitLineNumber(104, label18);
		methodVisitor.visitVarInsn(ALOAD, 5);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/RemoteProcess", "getOutputStream", "()Ljava/io/OutputStream;", false);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/OutputStream", "flush", "()V", false);
		Label label19 = new Label();
		methodVisitor.visitLabel(label19);
		methodVisitor.visitLineNumber(105, label19);
		methodVisitor.visitVarInsn(ALOAD, 5);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/RemoteProcess", "getOutputStream", "()Ljava/io/OutputStream;", false);
		methodVisitor.visitVarInsn(ALOAD, 9);
		methodVisitor.visitFieldInsn(GETSTATIC, "java/nio/charset/StandardCharsets", "UTF_8", "Ljava/nio/charset/Charset;");
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "getBytes", "(Ljava/nio/charset/Charset;)[B", false);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/OutputStream", "write", "([B)V", false);
		Label label20 = new Label();
		methodVisitor.visitLabel(label20);
		methodVisitor.visitLineNumber(106, label20);
		methodVisitor.visitVarInsn(ALOAD, 5);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/RemoteProcess", "getOutputStream", "()Ljava/io/OutputStream;", false);
		methodVisitor.visitIntInsn(BIPUSH, 13);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/OutputStream", "write", "(I)V", false);
		Label label21 = new Label();
		methodVisitor.visitLabel(label21);
		methodVisitor.visitLineNumber(107, label21);
		methodVisitor.visitVarInsn(ALOAD, 5);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/RemoteProcess", "getOutputStream", "()Ljava/io/OutputStream;", false);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/OutputStream", "flush", "()V", false);
		Label label22 = new Label();
		methodVisitor.visitLabel(label22);
		methodVisitor.visitLineNumber(108, label22);
		methodVisitor.visitVarInsn(ALOAD, 5);
		methodVisitor.visitLdcInsn(300L);
		methodVisitor.visitFieldInsn(GETSTATIC, "java/util/concurrent/TimeUnit", "MILLISECONDS", "Ljava/util/concurrent/TimeUnit;");
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/RemoteProcess", "waitFor", "(JLjava/util/concurrent/TimeUnit;)Z", false);
		methodVisitor.visitInsn(POP);
		Label label23 = new Label();
		methodVisitor.visitLabel(label23);
		methodVisitor.visitLineNumber(109, label23);
		methodVisitor.visitVarInsn(ALOAD, 5);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/RemoteProcess", "getOutputStream", "()Ljava/io/OutputStream;", false);
		methodVisitor.visitVarInsn(ALOAD, 1);
		methodVisitor.visitVarInsn(ALOAD, 1);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/execution/configurations/GeneralCommandLine", "getExePath", "()Ljava/lang/String;", false);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/execution/configurations/GeneralCommandLine", "getCommandLineString", "(Ljava/lang/String;)Ljava/lang/String;", false);
		methodVisitor.visitFieldInsn(GETSTATIC, "java/nio/charset/StandardCharsets", "UTF_8", "Ljava/nio/charset/Charset;");
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "getBytes", "(Ljava/nio/charset/Charset;)[B", false);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/OutputStream", "write", "([B)V", false);
		Label label24 = new Label();
		methodVisitor.visitLabel(label24);
		methodVisitor.visitLineNumber(110, label24);
		methodVisitor.visitVarInsn(ALOAD, 5);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/RemoteProcess", "getOutputStream", "()Ljava/io/OutputStream;", false);
		methodVisitor.visitIntInsn(BIPUSH, 13);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/OutputStream", "write", "(I)V", false);
		Label label25 = new Label();
		methodVisitor.visitLabel(label25);
		methodVisitor.visitLineNumber(111, label25);
		methodVisitor.visitVarInsn(ALOAD, 5);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/RemoteProcess", "getOutputStream", "()Ljava/io/OutputStream;", false);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/OutputStream", "flush", "()V", false);
		Label label26 = new Label();
		methodVisitor.visitLabel(label26);
		methodVisitor.visitLineNumber(112, label26);
		methodVisitor.visitTypeInsn(NEW, "com/intellij/remote/ColoredRemoteProcessHandler");
		methodVisitor.visitInsn(DUP);
		methodVisitor.visitVarInsn(ALOAD, 5);
		methodVisitor.visitVarInsn(ALOAD, 6);
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "val$project", "Lcom/intellij/openapi/project/Project;");
		methodVisitor.visitMethodInsn(INVOKESTATIC, "com/intellij/openapi/vfs/encoding/EncodingProjectManager", "getInstance", "(Lcom/intellij/openapi/project/Project;)Lcom/intellij/openapi/vfs/encoding/EncodingProjectManager;", false);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/openapi/vfs/encoding/EncodingProjectManager", "getDefaultCharset", "()Ljava/nio/charset/Charset;", false);
		methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/intellij/remote/ColoredRemoteProcessHandler", "<init>", "(Lcom/intellij/remote/RemoteProcess;Ljava/lang/String;Ljava/nio/charset/Charset;)V", false);
		methodVisitor.visitVarInsn(ASTORE, 8);
		methodVisitor.visitLabel(label1);
		methodVisitor.visitLineNumber(116, label1);
		Label label27 = new Label();
		methodVisitor.visitJumpInsn(GOTO, label27);
		methodVisitor.visitLabel(label2);
		methodVisitor.visitLineNumber(113, label2);
		methodVisitor.visitFrame(Opcodes.F_NEW, 8, new Object[]{"com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "com/intellij/execution/configurations/GeneralCommandLine", "com/intellij/ssh/ConnectionBuilder", "com/intellij/remote/RemoteSdkCredentials", "com/intellij/ssh/ProcessBuilder", "com/intellij/remote/DeferredRemoteProcess", "java/lang/String", "java/lang/String"}, 1, new Object[]{"java/lang/Exception"});
		methodVisitor.visitVarInsn(ASTORE, 9);
		Label label28 = new Label();
		methodVisitor.visitLabel(label28);
		methodVisitor.visitLineNumber(114, label28);
		methodVisitor.visitFieldInsn(GETSTATIC, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile", "LOG", "Lcom/intellij/openapi/diagnostic/Logger;");
		methodVisitor.visitVarInsn(ALOAD, 9);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/openapi/diagnostic/Logger", "error", "(Ljava/lang/Throwable;)V", false);
		Label label29 = new Label();
		methodVisitor.visitLabel(label29);
		methodVisitor.visitLineNumber(115, label29);
		methodVisitor.visitTypeInsn(NEW, "com/intellij/remote/ColoredRemoteProcessHandler");
		methodVisitor.visitInsn(DUP);
		methodVisitor.visitVarInsn(ALOAD, 5);
		methodVisitor.visitVarInsn(ALOAD, 7);
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "val$project", "Lcom/intellij/openapi/project/Project;");
		methodVisitor.visitMethodInsn(INVOKESTATIC, "com/intellij/openapi/vfs/encoding/EncodingProjectManager", "getInstance", "(Lcom/intellij/openapi/project/Project;)Lcom/intellij/openapi/vfs/encoding/EncodingProjectManager;", false);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/openapi/vfs/encoding/EncodingProjectManager", "getDefaultCharset", "()Ljava/nio/charset/Charset;", false);
		methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/intellij/remote/ColoredRemoteProcessHandler", "<init>", "(Lcom/intellij/remote/RemoteProcess;Ljava/lang/String;Ljava/nio/charset/Charset;)V", false);
		methodVisitor.visitVarInsn(ASTORE, 8);
		Label label30 = new Label();
		methodVisitor.visitLabel(label30);
		methodVisitor.visitLineNumber(116, label30);
		methodVisitor.visitJumpInsn(GOTO, label27);
		methodVisitor.visitLabel(label12);
		methodVisitor.visitLineNumber(118, label12);
		methodVisitor.visitFrame(Opcodes.F_NEW, 8, new Object[]{"com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "com/intellij/execution/configurations/GeneralCommandLine", "com/intellij/ssh/ConnectionBuilder", "com/intellij/remote/RemoteSdkCredentials", "com/intellij/ssh/ProcessBuilder", "com/intellij/remote/DeferredRemoteProcess", "java/lang/String", "java/lang/String"}, 0, new Object[]{});
		methodVisitor.visitTypeInsn(NEW, "com/intellij/remote/ColoredRemoteProcessHandler");
		methodVisitor.visitInsn(DUP);
		methodVisitor.visitVarInsn(ALOAD, 5);
		methodVisitor.visitVarInsn(ALOAD, 7);
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "val$project", "Lcom/intellij/openapi/project/Project;");
		methodVisitor.visitMethodInsn(INVOKESTATIC, "com/intellij/openapi/vfs/encoding/EncodingProjectManager", "getInstance", "(Lcom/intellij/openapi/project/Project;)Lcom/intellij/openapi/vfs/encoding/EncodingProjectManager;", false);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/openapi/vfs/encoding/EncodingProjectManager", "getDefaultCharset", "()Ljava/nio/charset/Charset;", false);
		methodVisitor.visitMethodInsn(INVOKESPECIAL, "com/intellij/remote/ColoredRemoteProcessHandler", "<init>", "(Lcom/intellij/remote/RemoteProcess;Ljava/lang/String;Ljava/nio/charset/Charset;)V", false);
		methodVisitor.visitVarInsn(ASTORE, 8);
		methodVisitor.visitLabel(label27);
		methodVisitor.visitLineNumber(120, label27);
		methodVisitor.visitFrame(Opcodes.F_NEW, 9, new Object[]{"com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "com/intellij/execution/configurations/GeneralCommandLine", "com/intellij/ssh/ConnectionBuilder", "com/intellij/remote/RemoteSdkCredentials", "com/intellij/ssh/ProcessBuilder", "com/intellij/remote/DeferredRemoteProcess", "java/lang/String", "java/lang/String", "com/intellij/remote/ColoredRemoteProcessHandler"}, 0, new Object[]{});
		methodVisitor.visitVarInsn(ALOAD, 8);
		methodVisitor.visitMethodInsn(INVOKESTATIC, "com/intellij/execution/process/ProcessTerminatedListener", "attach", "(Lcom/intellij/execution/process/ProcessHandler;)V", false);
		Label label31 = new Label();
		methodVisitor.visitLabel(label31);
		methodVisitor.visitLineNumber(121, label31);
		methodVisitor.visitVarInsn(ALOAD, 8);
		methodVisitor.visitInsn(DUP);
		Label label32 = new Label();
		methodVisitor.visitJumpInsn(IFNONNULL, label32);
		methodVisitor.visitInsn(ICONST_0);
		methodVisitor.visitMethodInsn(INVOKESTATIC, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "$$$reportNull$$$0", "(I)V", false);
		methodVisitor.visitLabel(label32);
		methodVisitor.visitFrame(Opcodes.F_NEW, 9, new Object[]{"com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "com/intellij/execution/configurations/GeneralCommandLine", "com/intellij/ssh/ConnectionBuilder", "com/intellij/remote/RemoteSdkCredentials", "com/intellij/ssh/ProcessBuilder", "com/intellij/remote/DeferredRemoteProcess", "java/lang/String", "java/lang/String", "com/intellij/remote/ColoredRemoteProcessHandler"}, 1, new Object[]{"com/intellij/remote/ColoredRemoteProcessHandler"});
		methodVisitor.visitInsn(ARETURN);
		Label label33 = new Label();
		methodVisitor.visitLabel(label33);
		methodVisitor.visitLocalVariable("id", "Ljava/lang/String;", null, label16, label1, 9);
		methodVisitor.visitLocalVariable("processHandler", "Lcom/intellij/remote/ColoredRemoteProcessHandler;", null, label1, label2, 8);
		methodVisitor.visitLocalVariable("e", "Ljava/lang/Exception;", null, label28, label30, 9);
		methodVisitor.visitLocalVariable("processHandler", "Lcom/intellij/remote/ColoredRemoteProcessHandler;", null, label30, label12, 8);
		methodVisitor.visitLocalVariable("this", "Lcom/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1;", null, label3, label33, 0);
		methodVisitor.visitLocalVariable("commandLine", "Lcom/intellij/execution/configurations/GeneralCommandLine;", null, label4, label33, 1);
		methodVisitor.visitLocalVariable("connectionBuilder", "Lcom/intellij/ssh/ConnectionBuilder;", null, label5, label33, 2);
		methodVisitor.visitLocalVariable("sdkData", "Lcom/intellij/remote/RemoteSdkCredentials;", null, label6, label33, 3);
		methodVisitor.visitLocalVariable("builder", "Lcom/intellij/ssh/ProcessBuilder;", null, label7, label33, 4);
		methodVisitor.visitLocalVariable("process", "Lcom/intellij/remote/RemoteProcess;", null, label9, label33, 5);
		methodVisitor.visitLocalVariable("path", "Ljava/lang/String;", null, label10, label33, 6);
		methodVisitor.visitLocalVariable("commandLineString", "Ljava/lang/String;", null, label11, label33, 7);
		methodVisitor.visitLocalVariable("processHandler", "Lcom/intellij/remote/ColoredRemoteProcessHandler;", null, label27, label33, 8);
		methodVisitor.visitMaxs(5, 10);
		methodVisitor.visitEnd();
	}

	public static void visitProcessTerminated(MethodVisitor methodVisitor, List<FilterRule> configList){
		AnnotationVisitor annotationVisitor = methodVisitor.visitTypeAnnotation(TypeReference.METHOD_FORMAL_PARAMETER, null, "Lorg/jetbrains/annotations/NotNull;", false);
		annotationVisitor.visitEnd();
		annotationVisitor = methodVisitor.visitParameterAnnotation(TypeReference.CLASS_TYPE_PARAMETER, "Lorg/jetbrains/annotations/NotNull;", false);
		annotationVisitor.visitEnd();
		methodVisitor.visitCode();
		Label label0 = new Label();
		methodVisitor.visitLabel(label0);
		methodVisitor.visitVarInsn(ALOAD, 1);
		Label label1 = new Label();
		methodVisitor.visitJumpInsn(IFNONNULL, label1);
		methodVisitor.visitInsn(ICONST_2);
		methodVisitor.visitMethodInsn(INVOKESTATIC, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1$1", "$$$reportNull$$$0", "(I)V", false);
		methodVisitor.visitLabel(label1);
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1$1", "this$1", "Lcom/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1;");
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1", "this$0", "Lcom/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile;");
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile", "myRemoteCredentials", "Lcom/intellij/remote/RemoteCredentials;");
		methodVisitor.visitMethodInsn(INVOKEINTERFACE, "com/intellij/remote/RemoteCredentials", "getHost", "()Ljava/lang/String;", true);
		methodVisitor.visitLdcInsn(configList.get(0).getRule());
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "contains", "(Ljava/lang/CharSequence;)Z", false);
		Label label2 = new Label();
		methodVisitor.visitJumpInsn(IFEQ, label2);
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1$1", "val$processHandler", "Lcom/intellij/execution/process/ProcessHandler;");
		methodVisitor.visitTypeInsn(INSTANCEOF, "com/intellij/remote/ColoredRemoteProcessHandler");
		methodVisitor.visitJumpInsn(IFEQ, label2);
		Label label3 = new Label();
		methodVisitor.visitLabel(label3);
		methodVisitor.visitVarInsn(ALOAD, 0);
		methodVisitor.visitFieldInsn(GETFIELD, "com/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1$1", "val$processHandler", "Lcom/intellij/execution/process/ProcessHandler;");
		methodVisitor.visitTypeInsn(CHECKCAST, "com/intellij/remote/ColoredRemoteProcessHandler");
		methodVisitor.visitVarInsn(ASTORE, 3);
		Label label4 = new Label();
		methodVisitor.visitLabel(label4);
		methodVisitor.visitVarInsn(ALOAD, 3);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/ColoredRemoteProcessHandler", "getProcess", "()Ljava/lang/Process;", false);
		methodVisitor.visitTypeInsn(CHECKCAST, "com/intellij/remote/DeferredRemoteProcess");
		methodVisitor.visitVarInsn(ASTORE, 4);
		Label label5 = new Label();
		methodVisitor.visitLabel(label5);
		methodVisitor.visitVarInsn(ALOAD, 4);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/DeferredRemoteProcess", "isDisconnected", "()Z", false);
		methodVisitor.visitJumpInsn(IFNE, label2);
		Label label6 = new Label();
		methodVisitor.visitLabel(label6);
		methodVisitor.visitVarInsn(ALOAD, 4);
		methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "com/intellij/remote/DeferredRemoteProcess", "destroy", "()V", false);
		methodVisitor.visitLabel(label2);
		methodVisitor.visitInsn(RETURN);
		Label label7 = new Label();
		methodVisitor.visitLabel(label7);
		methodVisitor.visitLocalVariable("processHandler1", "Lcom/intellij/remote/ColoredRemoteProcessHandler;", null, label4, label2, 3);
		methodVisitor.visitLocalVariable("remoteProcess", "Lcom/intellij/remote/DeferredRemoteProcess;", null, label5, label2, 4);
		methodVisitor.visitLocalVariable("this", "Lcom/jetbrains/plugins/remotesdk/tools/RemoteToolRunProfile$1$1;", null, label0, label7, 0);
		methodVisitor.visitLocalVariable("event", "Lcom/intellij/execution/process/ProcessEvent;", null, label0, label7, 1);
		methodVisitor.visitLocalVariable("willBeDestroyed", "Z", null, label0, label7, 2);
		methodVisitor.visitMaxs(2, 5);
		methodVisitor.visitEnd();
	}
}