sudo chmod +x ./scripts/host_usage.sh
# assign CLI arguments to variables
psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

# check if the number of parameters correct or not
if [ $# -ne 5 ]; then
  echo 'Illegal number of parameters'
  exit 1
fi

# parse host hardware specifications using bash cmds
hostname=$(echo `hostname -f`)
memory_free=$(echo "$(vmstat --unit M)" | tail -1 | awk '{print $4}' | xargs)
cpu_idle=$(echo "$(vmstat --unit M)" | tail -1 | awk '{print $15}' | xargs)
cpu_kernel=$(echo "$(vmstat --unit M)" | tail -1 | awk '{print $14}' | xargs)
disk_io=$(echo "$(vmstat -d)" | tail -1 | awk '{print $10}' | xargs)
disk_available=$(echo "$(df -BM /)" | tail -1 | awk '{print $4}'| sed 's\M\\g' | xargs)
timestamp=$(echo `date "+%Y-%m-%d %H:%M:%S" |  xargs`)

#Subquery to find matching id in host_info table
host_id="(SELECT id FROM host_info WHERE hostname='$hostname')"

# construct the INSERT statement from specification variables
insert_stmt="INSERT INTO host_usage (timestamp, host_id, memory_free, cpu_idle, cpu_kernel, disk_io, disk_available)
VALUES ('$timestamp', $host_id, '$memory_free', '$cpu_idle', '$cpu_kernel', '$disk_io', '$disk_available');"

# execute the INSERT statement through the psql CLI tool
export PGPASSWORD=$psql_password
psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit 0