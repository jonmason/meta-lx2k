DEPENDS += "rcw"
DEPENDS += "dtc-native"

FILESEXTRAPATHS_prepend := "${THISDIR}/files/:"

EDK2_SRC_URI = "gitsm://github.com/SolidRun/edk2.git"
EDK2_PLATFORMS_SRC_URI = "git://github.com/SolidRun/edk2-platforms.git"

SRC_URI += "git://github.com/SolidRun/edk2-non-osi;name=edk2-non-osi;destsuffix=edk2/edk2-non-osi;nobranch=1"
SRC_URI += "file://dpni_hack.patch"

SRCREV_edk2           = "ef3bbb20003ee0c300468c642499b3338b8ebf32"
SRCREV_edk2-platforms = "696d322818631d25c2295173258b0ededd847607"
SRCREV_edk2-non-osi   = "93839d3e676bc969dce82096f8d4c7076dc24c7c"
SRCREV_FORMAT         = "edk2_edk2-platforms_edk2-non-osi"

LIC_FILES_CHKSUM = "file://edk2-platforms/License.txt;md5=d734c2ca5ee83e0a2664828c2d697134"

EDK2_BUILD_RELEASE = "0"
EDK2_PLATFORM      = "LX2160aCex7"
EDK2_PLATFORM_DSC  = "Platform/SolidRun/LX2160aCex7/LX2160aCex7.dsc"
EDK2_BIN_NAME      = "LX2160ACEX7_EFI.fd"
EDK2_ARCH          = "AARCH64"

COMPATIBLE_MACHINE = "honeycomb_lx2k_uefi"

export PACKAGES_PATH       = "${S}:${S}/edk2-platforms:${S}:${S}/edk2-non-osi"
