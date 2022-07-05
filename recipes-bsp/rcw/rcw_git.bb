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
           file://0008-lx2160acex7-remove-all-predefined-RCW-files.patch \
           file://0009-lx2160acex7-remove-flexspi-divisor-optimization.patch \
           file://0010-lx210acex7-25Gbps-retimer-and-restructure-config.patch \
           file://0011-lx2160acex7-adjust-lanes-e-and-f-for-25g-links.patch \
           file://0012-lx2160acex7-added-SERDES-bank-2-with-pcie-x8.patch \
           file://0013-lx2160acex7-set-correctly-sdcard-card-detect-and-wri.patch \
           file://0014-lx2160acex7-more-SERDES-prototocol-configurations.patch \
           file://0015-lx2160acex7-add-SD1-mode-4-serdes-configuration.patch \
           file://yocto.patch \
	  "
SRCREV = "bd6675518e6cb22f731c53407cc0631aa240f49f"

LIC_FILES_CHKSUM = "file://LICENSE;md5=44a0d0fad189770cc022af4ac6262cbe"
S = "${WORKDIR}/git"

DEPENDS += "tcl-native"

SPEED="2000_700_${DDR_SPEED}"

do_compile() {
	mkdir -p ${S}/lx2160acex7/RCW
	echo "#include <configs/lx2160a_defaults.rcwi>" > ${S}/lx2160acex7/RCW/template.rcw
	echo "#include <configs/lx2160a_${SPEED}.rcwi>" >> ${S}/lx2160acex7/RCW/template.rcw
	echo "#include <configs/lx2160a_SD1_8.rcwi>" >> ${S}/lx2160acex7/RCW/template.rcw
	echo "#include <configs/lx2160a_SD2_5.rcwi>" >> ${S}/lx2160acex7/RCW/template.rcw
	echo "#include <configs/lx2160a_SD3_2.rcwi>" >> ${S}/lx2160acex7/RCW/template.rcw
	#echo "#include <configs/lx2160a_SD1_${SERDES}.rcwi>" >> ${S}/lx2160acex7/RCW/template.rcw
	#echo "#include <configs/lx2160a_SD2_${SERDES}.rcwi>" >> ${S}/lx2160acex7/RCW/template.rcw
	#echo "#include <configs/lx2160a_SD3_${SERDES}.rcwi>" >> ${S}/lx2160acex7/RCW/template.rcw
	mv ${S}/lx2160acex7/RCW/template.rcw ${S}/lx2160acex7/RCW/rcw_${SPEED}_${SERDES}_${BOOT}.rcw
	make
}

do_deploy() {
        install -m 0644 ${S}/lx2160acex7/RCW/rcw_${SPEED}_${SERDES}_${BOOT}.bin ${DEPLOYDIR}/
}
addtask deploy before do_build after do_compile
