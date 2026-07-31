SUMMARY = "UART echo shell script"
LICENSE = "CLOSED"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = " \
    file://uart-echo.sh \
    file://uart-echo.service \
"

SYSTEMD_SERVICE:${PN} = "uart-echo.service"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${UNPACKDIR}/uart-echo.sh ${D}${bindir}/uart-echo

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/uart-echo.service ${D}${systemd_system_unitdir}/uart-echo.service
}

inherit systemd
