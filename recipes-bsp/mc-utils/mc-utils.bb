DESCRIPTION = "Management Complex Utils for NXP DPAA2"
LICENSE = "Proprietary"

inherit deploy

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/mc-utils;protocol=https;nobranch=1 \
	   file://0001-lx2160acex7-add-8x10G-dual-40G-and-dual-100G-DPL-DPC.patch \
	  "
SRCREV = "18c77603733b3fcd0b716bf9800e052330941f4e"

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
