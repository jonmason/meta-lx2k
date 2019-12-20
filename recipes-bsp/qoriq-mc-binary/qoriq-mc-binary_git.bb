DESCRIPTION = "prebuild mc binaries"
LICENSE = "Proprietary"

inherit deploy

SRC_URI = "git://github.com/NXP/qoriq-mc-binary.git;protocol=https;nobranch=1"
SRCREV = "f73683596a7b72124d67b62e64f3dc2bb36b9321"

LIC_FILES_CHKSUM = "file://README;md5=21d68947125f84792e4a75871490748d"
S = "${WORKDIR}/git"

do_deploy() {
        install -m 0644 ${S}/lx2160a/mc_*_lx2160a.itb ${DEPLOYDIR}/
}

do_configure() {
        :
}

do_install() {
        :
}

addtask deploy before do_build after do_compile
