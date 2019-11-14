inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/linux;protocol=https;nobranch=1 \
	   file://defconfig \
	   file://0001-arm64-dts-lx2160a-add-lx2160acex7-device-tree-build.patch \
	   file://0002-arm64-dts-lx2160a-add-lx2160acex7-device-tree.patch \
	   file://0003-arm64-dts-lx2160a-misc-fixes.patch \
	  "
SRCREV = "33f2c86df727a5651c22329265704adfa3518549"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KERNEL_VERSION_SANITY_SKIP = "1"

LICENSE = "GPLv2 & LGPLv2"

S = "${WORKDIR}/git"
