DESCRIPTION = "prebuild mc binaries"
LICENSE = "Proprietary"

inherit deploy

SRC_URI = "git://github.com/NXP/qoriq-mc-binary.git;protocol=https;nobranch=1"
SRCREV = "f72b978873af6c7cd0fd92b793363506411c102c"

LIC_FILES_CHKSUM = "file://README;md5=21d68947125f84792e4a75871490748d"
S = "${WORKDIR}/git"

do_deploy() {
        install -m 0644 ${S}/lx2160a/mc_10.16.2_lx2160a.itb ${DEPLOYDIR}/
}

do_configure() {
        :
}

do_install() {
        :
}

addtask deploy before do_build after do_compile
