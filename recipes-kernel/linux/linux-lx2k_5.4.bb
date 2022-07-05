require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/linux;protocol=https;nobranch=1 \
           file://0001-arm64-dts-lx2160a-add-lx2160acex7-device-tree-build.patch \
           file://0002-arm64-dts-lx2160a-add-lx2160acex7-device-tree.patch \
           file://0003-arm64-dts-lx2160a-cex7-add-ltc3882-support.patch \
           file://0004-arm64-dts-lx2160a-cex7-add-on-module-eeproms.patch \
           file://0005-lx2160a-dwc3-dts-disable-usb3-parkmode.patch \
           file://0006-arm64-dts-lx2160a-cex7-add-power-button-support.patch \
           file://0007-aarm64-dts-lx2160a-cex7-add-secondary-spi-flash-supp.patch \
           file://defconfig \
	  "
SRCREV = "6bff40d413b394c2d742e7a42089bfc62aef0a9b"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

#KBUILD_DEFCONFIG = "defconfig"
#KCONFIG_MODE = "--alldefconfig"

LINUX_VERSION = "5.4.47"
KMETA = "kernel-meta"

PV = "${LINUX_VERSION}+git${SRCPV}"
