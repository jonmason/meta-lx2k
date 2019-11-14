require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

SUMMARY = "U-Boot bootloader for LX2160A"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
# u-boot needs devtree compiler to parse dts files
#DEPENDS += "dtc-native bc-native bison"
DEPENDS += "flex-native bison-native"
SRCREV = "2295e61474ddf140a52842116b3c44cab4decde2"
#SRCREV = "${AUTOREV}"

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/u-boot;protocol=https;nobranch=1 \
	   file://0001-armv8-add-lx2160acex7-build-inclusion.patch \
	   file://0002-armv8-lx2160acex-misc-hacks-to-get-the-sources-built.patch \
	   file://0003-armv8-lx2160acex7-defconfig-and-main-platform-includ.patch \
	   file://0004-armv8-lx2160acex7-common-files-for-platform-support.patch \
	   file://0005-armv8-lx2160acex7-lx2160acex-device-tree.patch \
	   file://0006-armv8-lx2160acex7-board-support-files.patch \
	   file://0007-yocto.patch \
	  "

S = "${WORKDIR}/git"
