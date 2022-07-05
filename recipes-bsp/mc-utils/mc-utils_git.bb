DESCRIPTION = "Management Complex Utils for NXP DPAA2"
LICENSE = "Proprietary"

inherit deploy

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/mc-utils;protocol=https;nobranch=1 \
           file://0001-lx2160acex7-add-8x10G-dual-40G-and-dual-100G-DPL-DPC.patch \
           file://0002-Add-CEX7-4x25Gbps-support.patch \
           file://0003-lx2160acex7-add-single-100Gbps-support.patch \
           file://0004-lx2160acex7-add-backplane-support.patch \
           file://0005-lx2160acex7-add-dpc-dpl-for-sd1-protocol-18.patch \
           file://0006-lx2160acex7-add-DPL-DPC-files-for-SD1-protocol-21.patch \
           file://0006-lx2160acex7-upgrade-network-ports-from-fixed-link-to.patch \
           file://0007-lx2160acex7-half-twins-configuration.patch \
           file://0008-lx2160acex7-Limit-internal-MC-recycle-queues-to-1G.patch \
	  "
SRCREV = "8e0b863693fc2ccbc62a62c79b4e3db6da88c16e"

LIC_FILES_CHKSUM = "file://LICENSE;md5=386a6287daa6504b7e7e5014ddfb3987"
S = "${WORKDIR}/git"

DEPENDS += "dtc-native"

do_compile() {
	oe_runmake -C ${S}/config
}

do_deploy() {
	if [ "$SERDES" = "13_5_2" ]; then
		install -m 0644 ${S}/config/lx2160a/CEX7/*100g*.dtb ${DEPLOYDIR}/
	elif [ "$SERDES" = "20_5_2" ]; then
		install -m 0644 ${S}/config/lx2160a/CEX7/*40g*.dtb ${DEPLOYDIR}/
	else
		install -m 0644 ${S}/config/lx2160a/CEX7/*8*.dtb ${DEPLOYDIR}/
	fi
}
addtask deploy before do_build after do_compile
