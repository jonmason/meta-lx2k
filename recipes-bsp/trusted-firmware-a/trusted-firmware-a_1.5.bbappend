THISDIR := "${THISDIR}"
FILESEXTRAPATHS:prepend = "${THISDIR}/files/:"

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/atf;protocol=https;nobranch=1 \
           file://0001-plat-nxp-fsl_sec-Mask-job-ring-interrupts-in-POLLING.patch \
           file://0002-drivers-nxp-ddr-Enable-workaround-for-Erratum-A05045.patch \
           file://0003-plat-nxp-ls1088a-fix-erratum-A-011127-about-LPM20.patch \
           file://0004-ls1046a-remove-workaround-for-QSPI-issue-during-lpm2.patch \
           file://0005-plat-nxp-ls1088a-fix-erratum-A-010194-about-LPM20.patch \
           file://0006-plat-nxp-ls1048a-fix-swlpm20-hang.patch \
           file://0007-plat-nxp-fsl_sec-increase-job-ring-size-to-128.patch \
           file://0008-plat-nxp-Add-lx2160acex7-module-support.patch \
           file://0009-plat-nxp-lx2160a-auto-boot.patch \
           file://0010-lx2160acex7-assert-SUS_S5-GPIO-to-poweroff-the-COM.patch \
           file://0011-lx2160a-fix-SVR-12c-mask.patch \
           file://0012-plat-nxp-efuse-io-storage-must-be-checked-first.patch \
           file://0013-plat-nxp-sfp-driver-GPIO-fixes-and-PPWM-setting.patch \
           file://0014-lx2160acex7-add-timer-based-counter.patch \
           file://0015-plat-nxp-add-tool-print-when-choosing-autodetect-mod.patch \
           file://yocto.patch \
          "
SRCREV = "7d748e6f0ec652ba7c43733dc67a3d0b0217390a"

COMPATIBLE_MACHINE = "honeycomb_lx2k"
TFA_PLATFORM = "lx2160acex7"
TFA_BUILD_TARGET = "fip pbl"
TFA_INSTALL_TARGET = "fip"

EXTRA_OEMAKE += "RCW=${DEPLOY_DIR_IMAGE}/rcw_*_${DDR_SPEED}_${SERDES}_${BOOT}.bin BOOT_MODE=${BOOT}"
EXTRA_OEMAKE += "${@bb.utils.contains('TFA_UBOOT', '1', 'BL33=${DEPLOY_DIR_IMAGE}/u-boot.bin', '',d)}"
EXTRA_OEMAKE += "${@bb.utils.contains('TFA_UBOOT', '0', 'BL33=${DEPLOY_DIR_IMAGE}/uefi.bin', '',d)}"

do_compile[depends] += "rcw:do_deploy"

do_deploy:append() {
        install -m 0644 ${BUILD_DIR}/bl2_${BOOT}.pbl ${DEPLOYDIR}/
}
