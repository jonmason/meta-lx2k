# Firmware Image Package (FIP)
# It is a packaging format used by TF-A to package the
# firmware images in a single binary.

DESCRIPTION = "fiptool - Trusted Firmware tool for packaging"
LICENSE = "BSD-3-Clause"

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/atf;protocol=https;nobranch=1"
LIC_FILES_CHKSUM = "file://license.rst;md5=e927e02bca647e14efd87e9e914b2443"

# Use fiptool from TF-A v1.5
SRCREV = "4a82c939a0211196e2b80a495f966383803753bb"

DEPENDS += "openssl-native"

inherit native

S = "${WORKDIR}/git"

do_compile () {
    # These changes are needed to have the fiptool compiling and executing properly
    sed -i '/^LDLIBS/ s,$, \$\{BUILD_LDFLAGS},' ${S}/tools/fiptool/Makefile
    sed -i '/^INCLUDE_PATHS/ s,$, \$\{BUILD_CFLAGS},' ${S}/tools/fiptool/Makefile

    oe_runmake fiptool
}

do_install () {
    install -d ${D}${bindir}/
    install -m 0755 tools/fiptool/fiptool ${D}${bindir}
}
