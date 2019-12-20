DESCRIPTION = "Trusted Firmware-A for lx2k"
LICENSE = "BSD-3-Clause"

inherit deploy

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/atf;protocol=https;nobranch=1 \
	   file://0001-plat-nxp-Add-lx2160acex7-module-support.patch \
           file://0002-plat-nxp-lx2160a-auto-boot.patch \
	  "
SRCREV = "4a82c939a0211196e2b80a495f966383803753bb"

LIC_FILES_CHKSUM = "file://license.rst;md5=e927e02bca647e14efd87e9e914b2443"
S = "${WORKDIR}/git"

export CROSS_COMPILE = "${TARGET_PREFIX}"
CFLAGS[unexport] = "1"
LDFLAGS[unexport] = "1"
AS[unexport] = "1"
LD[unexport] = "1"

#PROVIDES += "fiptool"
DEPENDS += "u-boot rcw"
do_compile[depends] += "u-boot:do_deploy"
do_compile[depends] += "rcw:do_deploy"

do_clean() {
	oe_runmake -C ${S} distclean
}

do_compile() {
	oe_runmake PLAT=lx2160acex7 all fip pbl BL33=${DEPLOY_DIR_IMAGE}/u-boot.bin RCW=${DEPLOY_DIR_IMAGE}/rcw_*_${DDR_SPEED}_${SERDES}_${BOOT}.bin TRUSTED_BOARD_BOOT=0 GENERATE_COT=0 BOOT_MODE=${BOOT} SECURE_BOOT=false
}

do_deploy() {
	install -m 0644 ${S}/build/lx2160acex7/release/bl2_${BOOT}.pbl ${DEPLOYDIR}/
	install -m 0644 ${S}/build/lx2160acex7/release/fip.bin ${DEPLOYDIR}/
	install -m 0777 ${S}/tools/fiptool/fiptool ${DEPLOYDIR}/
}
addtask deploy before do_build after do_compile
