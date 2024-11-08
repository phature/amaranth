# CentOS Stream 9配置

## OpenAnolis

[2025 S2 Anolis OS 25 LTS](https://gitee.com/anolis/rnotes/blob/master/anolis/policy/life-cycle.md)

## OpenCloudOS

[2023 OpenCloudOS 9](https://docs.opencloudos.org/release/oc_intro/)

[2027 OpenCloudOS 10](https://docs.opencloudos.org/release/oc_intro/)

## OpenEuler

[2024.06.06 openEuler 24.03 LTS](https://gitee.com/openeuler/release-management/blob/master/openEuler-24.03-LTS/release-plan.md)

## USER

``` shell
mkdir ~/.ssh
```

``` shell
echo "" >> ~/.bashrc && echo "alias sudo='sudo '" >> ~/.bashrc && source ~/.bashrc
```

``` shell
sudo useradd --gid `id -g` --uid 1024 --groups wheel guest
```

``` shell
sudo passwd guest
```

## GRUB

``` shell
sudo sed -i s/GRUB_TIMEOUT=5/GRUB_TIMEOUT=1/g /etc/default/grub
```

``` shell
sudo sed -i s/GRUB_DEFAULT=saved/GRUB_DEFAULT=0/g /etc/default/grub
```

``` shell
sudo sed -i s/GRUB_CMDLINE_LINUX=\"/GRUB_CMDLINE_LINUX=\"video=2560x1440\ /g /etc/default/grub
```

``` shell
sudo grub2-mkconfig -o /boot/grub2/grub.cfg
```

## Plymouth

``` shell
sudo plymouth-set-default-theme -R details
```

## TTY字体

``` shell
sudo sed -i s/eurlatgr/latarcyrheb-sun32/g /etc/vconsole.conf
```

## SELINUX

``` shell
sudo sed -i s/SELINUX=enforcing/SELINUX=disabled/g /etc/selinux/config
```

## SECURITY

``` shell
sudo sed -i "s/Defaults    env_reset/Defaults    env_reset,timestamp_timeout=-1/g" /etc/sudoers
```

``` shell
sudo sed -i s/dcredit=-1/dcredit=0/g /etc/pam.d/system-auth
```

## Systemd

``` shell
sudo systemctl disable firewalld.service
```

## DNF

``` shell
sudo dnf install -y tar zip unzip curl wget telnet nfs-utils tree
```

## /etc/fstab

``` shell
echo "" | sudo tee -a /etc/fstab
```

``` shell
echo "/dev/mapper/singleton-datum /singleton/datum xfs noauto,defaults 0 0" | sudo tee -a /etc/fstab
```

``` shell
echo "/dev/mapper/mirror-datum    /mirror/datum    xfs noauto,defaults 0 0" | sudo tee -a /etc/fstab
```

## Network

``` shell
echo "" | sudo tee -a /etc/hosts && echo 192.168.122.109 $HOSTNAME | sudo tee -a /etc/hosts
```

``` shell
sudo nmcli connection delete eth0 && sudo nmcli connection add con-name eth0 ifname eth0 type ethernet ipv6.method ignore ipv4.method auto ipv4.route-metric 0
```

``` shell
sudo nmcli connection delete eth1 && sudo nmcli connection add con-name eth1 ifname eth1 type ethernet ipv6.method ignore ipv4.method manual ipv4.addresses 192.168.122.109/24 ipv4.gateway 192.168.122.1 ipv4.route-metric 128
```

## SCRIPT

### change_file_system.sh

``` shell
cat > change_file_system.sh << "EOF"
#!/bin/bash

sudo rm -Rf /etc/lvm/

for TARGET_MOUNT in `sudo lvs | awk -F " " '{print "/"$2"/"$1}'`
do
  SOURCE_FS=`grep $TARGET_MOUNT /etc/fstab | grep noauto`
  if [ -n "$SOURCE_FS" ] ; then
    sudo mkdir -p $TARGET_MOUNT
    TARGET_FS=`echo "$SOURCE_FS" | awk -F "noauto," '{print $1$2}'`
    sudo sed -i "s#$SOURCE_FS#$TARGET_FS#g" /etc/fstab
  fi
done

sudo systemctl daemon-reload
EOF
```

### change_host_name.sh

``` shell
cat > change_host_name.sh << "EOF"
#!/bin/bash

TARGET_HOSTNAME=$1

if [[ "$TARGET_HOSTNAME" =~ ^[a-z|0-9|-]*-[0-9]{1,3}$ ]] ; then
  SOURCE_HOSTNAME=`cat /etc/hostname`
  SOURCE_IP=`grep $SOURCE_HOSTNAME /etc/hosts | awk -F " " '{print $1}'`
  IP_PREFIX=`echo $SOURCE_IP | awk -F "." '{print $1"."$2"."$3"."}'`
  IP_POSTFIX_TEXT=`echo $TARGET_HOSTNAME | awk -F "-" '{print $NF}'`
  IP_POSTFIX=`expr $IP_POSTFIX_TEXT + 0`
  TARGET_IP=`echo "$IP_PREFIX$IP_POSTFIX"`

  if [ $IP_POSTFIX -gt 1 ] && [ $IP_POSTFIX -lt 255 ] ; then
    sudo sed -i "s#$SOURCE_HOSTNAME#$TARGET_HOSTNAME#g" /etc/hostname
    sudo sed -i "s#$SOURCE_HOSTNAME#$TARGET_HOSTNAME#g" /etc/hosts
    sudo sed -i "s#$SOURCE_IP#$TARGET_IP#g" /etc/hosts
    sudo sed -i "s#$SOURCE_IP#$TARGET_IP#g" /etc/NetworkManager/system-connections/eth1.nmconnection
  else
    echo "1 < IP < 255"
  fi
else
  echo "HOSTNAME=^[a-z|0-9|-]*-[0-9]{1,3}$"
fi
EOF
```

### change_ip_segment.sh

``` shell
cat > change_ip_segment.sh << "EOF"
#!/bin/bash

TARGET_SEGMENT=$1

if [[ "$TARGET_SEGMENT" =~ ^[0-9]{1,3}$ ]] ; then
  SOURCE_HOSTNAME=`cat /etc/hostname`
  SOURCE_IP=`grep $SOURCE_HOSTNAME /etc/hosts | awk -F " " '{print $1}'`
  SOURCE_IP_PREFIX=`echo $SOURCE_IP | awk -F "." '{print $1"."$2"."$3"."}'`
  TARGET_SEGMENT_PREFIX=`echo $SOURCE_IP | awk -F "." '{print $1"."$2"."}'`
  TARGET_IP_PREFIX=`echo "${TARGET_SEGMENT_PREFIX}${TARGET_SEGMENT}."`

  if [ $TARGET_SEGMENT -lt 256 ] ; then
    sudo sed -i "s#$SOURCE_IP_PREFIX#$TARGET_IP_PREFIX#g" /etc/hosts
    sudo sed -i "s#$SOURCE_IP_PREFIX#$TARGET_IP_PREFIX#g" /etc/NetworkManager/system-connections/eth1.nmconnection
  else
    echo "SEGMENT < 256"
  fi
else
  echo "SEGMENT=^[0-9]{1,3}$"
fi
EOF
```

### mount_nfs_192_168_122_200_mirror_datum_mnt.sh

``` shell
cat > mount_nfs_192_168_122_200_mirror_datum_mnt.sh << "EOF"
#!/bin/bash

sudo mount -t nfs 192.168.122.200:/mirror/datum/nfs /mnt
EOF
```

### rename_administrator.sh

``` shell
cat > rename_administrator.sh << "EOF"
#!/bin/bash

NEW_USERNAME=$1

if [[ ! -z "${NEW_USERNAME}" ]] ; then
        sudo groupmod --new-name ${NEW_USERNAME} administrator
        sudo usermod --comment ${NEW_USERNAME} --home /home/${NEW_USERNAME} --move-home --login ${NEW_USERNAME} administrator
else
        echo "require new username."
fi
EOF
```

``` shell
chmod 755 *.sh
```

``` shell
sudo mkdir /home/guest/script
```

``` shell
sudo cp *.sh /home/guest/script/
```

``` shell
sudo chown -R guest:administrator /home/guest/script/
```
