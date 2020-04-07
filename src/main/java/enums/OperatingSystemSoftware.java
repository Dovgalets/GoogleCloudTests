package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OperatingSystemSoftware {
    Free_Debian_CentOS_CoreOS_Ubuntu_OrOtherUserProvidedOS("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS"),
    Paid_WindowsServer2008r2_WindowsServer2012r2_WindowsServer2016_WindowsCore("Paid: Windows Server 2008r2, Windows Server 2012r2, Windows Server 2016, Windows Core"),
    Paid_RedHatEnterpriseLinux("Paid: Red Hat Enterprise Linux");

    private String operatingSystem;

    public static OperatingSystemSoftware fromString(String operatingSystem) {
        for (OperatingSystemSoftware data : values()) {
            if (data.operatingSystem.equals(operatingSystem))
                return data;
        }
        return null;
    }
}
