require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SUMMARY = "U-Boot bootloader for LX2160A"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
DEPENDS += "flex-native bison-native"
DEPENDS += "bc-native dtc-native"

S = "${WORKDIR}/git"
B = "${WORKDIR}/build"
do_configure[cleandirs] = "${B}"
PE = "1"
SECTION = "bootloaders"

UBOOT_INITIAL_ENV = ""

SRCREV = "f46a944f715f284aff1d42c009680ffe0be4058f"

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/u-boot;protocol=https;nobranch=1 \
           file://0001-armv8-add-lx2160acex7-build-inclusion.patch \
           file://0002-armv8-lx2160acex7-defconfig-and-main-platform-includ.patch \
           file://0003-armv8-lx2160acex7-common-files-for-platform-support.patch \
           file://0004-armv8-lx2160acex7-lx2160acex-device-tree.patch \
           file://0005-armv8-lx2160acex7-board-support-files.patch \
           file://0006-uboot-add-nvme-commands-and-for-distroboot.patch \
           file://0007-armv8-lx2160acex7-Fix-booting-from-NVMe-drives.patch \
           file://0008-lx2160acex7-common-update-vid-to-LSDK-20.12.patch \
           file://0009-lx2160a-cex7-move-from-lsdk-19.06-to-lsdk-19.09.patch \
           file://0010-lx2160acex7-pcie-fixup-and-boot-from-eMMC-print.patch \
           file://0011-lx2160a-cex7-set-mmc-dev-to-0-when-attempting-sd_boo.patch \
           file://0012-lx2160acex7-Misc-fixes-to-support-LSDK-20.04.patch \
           file://0013-lx2160acex7-misc-fixes-to-get-booting-from-eMMC-func.patch \
           file://0014-lx2160a-add-ramdisk_addr_r-for-distro-boot-support.patch \
           file://0015-pci-fix-layerscape.patch \
           file://0016-lx2160acex7-add-poweroff-and-disable-fan-full-speed.patch \
           file://0017-lx2160acex7-drop-ramdisk-from-default-bootargs.patch \
           file://0018-lx2160acex7-add-25Gbps-TI-retimer-configuration.patch \
           file://0019-lx2160acex7-refine-pre-cursor-of-all-channels-to-4.patch \
           file://0020-lx2160acex7-add-sys_eeprom-support-and-read-MAC-addr.patch \
           file://0021-lx2160a-set-dpaa-mac-registration-as-weak-and-clear-.patch \
           file://0022-lx2160acex7-add-mtest-start-and-end-addresses.patch \
           file://0023-lx2160acex7-add-10Gbps-retimer-configuration.patch \
           file://0024-lx2160acex7-add-support-for-LSDK-20.12-and-it-s-newe.patch \
           file://0025-lx2160a-modify-SVR_WO_E-mask.patch \
           file://0026-lx2160acex7-add-secureboot-defconfig.patch \
           file://yocto.patch \
	  "
