inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/linux;protocol=https;nobranch=1 \
	   file://defconfig \
           file://0001-arm64-dts-lx2160a-add-lx2160acex7-device-tree-build.patch \
           file://0002-arm64-dts-lx2160a-add-lx2160acex7-device-tree.patch \
           file://0003-arm64-dts-lx2160a-cex7-add-ltc3882-support.patch \
           file://0004-arm64-dts-lx2160a-cex7-add-on-module-eeproms.patch \
           file://0005-pci-hotplug-declare-IDT-bridge-as-hotpluggabl-bridge.patch \
           file://0006-pci-spr2803-quirk-to-fix-class-ID.patch \
	  "
SRCREV = "f8118585ee3c7025265b28985fdfe0af96a84466"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

KERNEL_VERSION_SANITY_SKIP = "1"

LICENSE = "GPLv2 & LGPLv2"

S = "${WORKDIR}/git"
