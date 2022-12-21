# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
#
#-keepclassmembers class org.bouncycastle.jsse.BCSSLParameters {*;}
#-dontwarn org.bouncycastle.jsse.BCSSLParameters
#
#-keepclassmembers class org.bouncycastle.jsse.BCSSLSocket {*;}
#-dontwarn org.bouncycastle.jsse.BCSSLSocket
#
#-keepclassmembers class org.bouncycastle.jsse.provider.BouncyCastleJsseProvider {*;}
#-dontwarn org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
#
#-keepclassmembers class org.conscrypt.Conscrypt$Version {*;}
#-dontwarn org.conscrypt.Conscrypt$Version
#
#-keepclassmembers class org.conscrypt.Conscrypt {*;}
#-dontwarn org.conscrypt.Conscrypt
#
#-keepclassmembers class org.conscrypt.ConscryptHostnameVerifier {*;}
#-dontwarn org.conscrypt.ConscryptHostnameVerifier
#
#-keepclassmembers class org.openjsse.javax.net.ssl.SSLParameters {*;}
#-dontwarn org.openjsse.javax.net.ssl.SSLParameters
#
#-keepclassmembers class org.openjsse.javax.net.ssl.SSLSocket {*;}
#-dontwarn org.openjsse.javax.net.ssl.SSLSocket
#
#-keepclassmembers class org.openjsse.net.ssl.OpenJSSE {*;}
#-dontwarn org.openjsse.net.ssl.OpenJSSE
#
# # Keep generic signature of Call, Response (R8 full mode strips signatures from non-kept items).
# -keep,allowobfuscation,allowshrinking interface retrofit2.Call
# -keep,allowobfuscation,allowshrinking class retrofit2.Response
#
# # With R8 full mode generic signatures are stripped for classes that are not
# # kept. Suspend functions are wrapped in continuations where the type argument
# # is used.
# -keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
#
#     ##---------------Begin: proguard configuration for Gson  ----------
# # Gson uses generic type information stored in a class file when working with fields. Proguard
# # removes such information by default, so configure it to keep all of it.
# -keepattributes Signature
#
# # For using GSON @Expose annotation
# -keepattributes *Annotation*
#
# # Gson specific classes
# -keep class sun.misc.Unsafe { *; }
# #-keep class com.google.gson.stream.** { *; }
#
# # Application classes that will be serialized/deserialized over Gson
# -keep class com.google.gson.examples.android.model.** { *; }
#
# # Prevent proguard from stripping interface information from TypeAdapterFactory,
# # JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
# -keep class * implements com.google.gson.TypeAdapterFactory
# -keep class * implements com.google.gson.JsonSerializer
# -keep class * implements com.google.gson.JsonDeserializer
#
# ##---------------End: proguard configuration for Gson  ----------
#
# -keep public class com.example.barangbekas.data.remote.model.Category
## -keep public class UserPosts