#include <jni.h>

JNIEXPORT jint JNICALL
Java_id_ac_ui_cs_mobileprogramming_michaelsusanto_helloworld_MainActivity_nativeSum(
    JNIEnv* env,
    jobject thiz,
    int firstNum,
    int secondNum
    ) {
    int sum = firstNum + secondNum;
    return sum;
}