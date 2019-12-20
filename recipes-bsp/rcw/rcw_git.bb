DESCRIPTION = "RCW for lx2160acex7"
LICENSE = "BSD-3-Clause"

inherit python3native deploy

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-components/rcw;protocol=https;nobranch=1 \
           file://0001-lx2160acex7-misc-RCW-files.patch \
           file://0002-Set-io-pads-as-GPIO.patch \
           file://0003-S2-enable-gen3-xspi-increase-divisor-to-28.patch \
           file://0004-refactor-a009531-a008851-and-a011270.patch \
           file://0005-lx2160a-add-SVR-check-for-a050234-to-apply-only-on-r.patch \
           file://0006-lx2160acex7-pcie-workarounds-and-fan-full-speed.patch \
           file://0007-lx2160a-add-generic-bootloc-section.patch \
	   file://0004-yocto.patch \
	  "
SRCREV = "5689bf9c9f087f50aaa0d91b43d8a791fedbedd3"

LIC_FILES_CHKSUM = "file://LICENSE;md5=44a0d0fad189770cc022af4ac6262cbe"
S = "${WORKDIR}/git"

DEPENDS += "tcl-native"

do_deploy() {
        install -m 0644 ${S}/lx2160acex7/XGGFF_PP_HHHH_RR_19_5_2/rcw*${DDR_SPEED}_${SERDES}_${BOOT}.bin ${DEPLOYDIR}/
}
addtask deploy before do_build after do_compile
