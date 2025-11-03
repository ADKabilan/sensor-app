SUMMARY = "Simple sensor library"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/ADKabilan/sensor-app.git;protocol=https;branch=master"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git/files"

do_compile() {
    ${CC} ${CFLAGS} -fPIC -c sensor_lib.c -o sensor_lib.o
    ${CC} ${LDFLAGS} -shared -o libsensor.so sensor_lib.o
}

do_install() {
    install -d ${D}${libdir}
    install -m 0755 libsensor.so ${D}${libdir}/

    install -d ${D}${includedir}
    install -m 0644 sensor_lib.h ${D}${includedir}/
}
