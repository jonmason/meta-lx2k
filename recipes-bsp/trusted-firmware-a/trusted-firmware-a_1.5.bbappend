THISDIR := "${THISDIR}"
FILESEXTRAPATHS_prepend = "${THISDIR}/files/:"

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/atf;protocol=https;nobranch=1 \
           file://0001-plat-nxp-Add-lx2160acex7-module-support.patch \
           file://0002-plat-nxp-lx2160a-auto-boot.patch \
          "
SRCREV = "4a82c939a0211196e2b80a495f966383803753bb"

COMPATIBLE_MACHINE = "honeycomb_lx2k"
TFA_PLATFORM = "lx2160acex7"
TFA_UBOOT = "1"
TFA_BUILD_TARGET = "fip pbl"
TFA_INSTALL_TARGET = "fip"

EXTRA_OEMAKE += "RCW=${DEPLOY_DIR_IMAGE}/rcw_*_${DDR_SPEED}_${SERDES}_${BOOT}.bin BOOT_MODE=${BOOT}"

do_compile[depends] += "rcw:do_deploy"

do_deploy_append() {
        install -m 0644 ${BUILD_DIR}/bl2_${BOOT}.pbl ${DEPLOYDIR}/
}
