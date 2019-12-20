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

SRCREV = "ce862bb2d2aa3b2a69bc580c57dce67d84ac1b99"

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/u-boot;protocol=https;nobranch=1 \
	   file://0001-armv8-add-lx2160acex7-build-inclusion.patch \
	   file://0002-armv8-lx2160acex-misc-hacks-to-get-the-sources-built.patch \
	   file://0003-armv8-lx2160acex7-defconfig-and-main-platform-includ.patch \
	   file://0004-armv8-lx2160acex7-common-files-for-platform-support.patch \
	   file://0005-armv8-lx2160acex7-lx2160acex-device-tree.patch \
	   file://0006-armv8-lx2160acex7-board-support-files.patch \
	   file://0007-load-dpl-into-0x80001000-instead-of-0x80d00000.patch \
	   file://0008-uboot-add-nvme-commands-and-for-distroboot.patch \
	   file://0009-armv8-lx2160acex7-Fix-booting-from-NVMe-drives.patch \
	   file://0010-nvme-Fix-warning-of-cast-from-pointer-to-integer-of-.patch \
	   file://0011-nvme-Fix-PRP-Offset-Invalid.patch \
	   file://0012-nvme-add-accessor-to-namespace-id-and-eui64.patch \
	   file://0013-nvme-flush-dcache-on-both-r-w-and-the-prp-list.patch \
	   file://0014-nvme-use-page-aligned-buffer-for-identify-command.patch \
	   file://0007-yocto.patch \
	  "
