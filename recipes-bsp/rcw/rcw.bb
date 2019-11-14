DESCRIPTION = "RCW for lx2160acex7"
LICENSE = "BSD-3-Clause"

inherit deploy

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/rcw;protocol=https;nobranch=1 \
	   file://0001-lx2160acex7-misc-RCW-files.patch \
	   file://0002-Set-io-pads-as-GPIO.patch \
	   file://0003-S2-enable-gen3-xspi-increase-divisor-to-28.patch \
	   file://0004-yocto.patch \
	  "
SRCREV = "49c3000b81b3b544778af10a324681b33c5c2ec6"

LIC_FILES_CHKSUM = "file://LICENSE;md5=45a017ee5f4cfe64b1cddf2eb06cffc7"
S = "${WORKDIR}/git"

DEPENDS += "tcl-native"

do_deploy() {
        install -m 0644 ${S}/lx2160acex7/XGGFF_PP_HHHH_RR_19_5_2/rcw*${DDR_SPEED}_${SERDES}_${BOOT}.bin ${DEPLOYDIR}/
}
addtask deploy before do_build after do_compile
