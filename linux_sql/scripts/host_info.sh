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
lscpu_out=`lscpu`
hostname=$(hostname -f)
cpu_number=$(echo "$lscpu_out"  | egrep "^CPU\(s\):" | '{print $2}' | xargs)
cpu_architecture=$(echo "$lscpu_out"  | egrep "Architecture:" | awk '{print $2}' | xargs)
cpu_model=$(echo "$lscpu_out"  | egrep "Model name:" | awk '{for(i=3;i<=NF;++i)print $i}' | xargs)
cpu_mhz=$(echo "$lscpu_out"  | egrep "CPU MHz:" | awk '{print $3}' | xargs)
l2_cache=$(echo "$lscpu_out"  | egrep "L2 cache:" | awk '{print $3}' | sed -e 's/K//g' |  xargs)
total_mem=$(awk '/^MemTotal:/{print $2}' /proc/meminfo)
timestamp=$(date "+%Y-%m-%d %H:%M:%S" "$@")

# construct the INSERT statement from specification variables
insert_stmt="INSERT INTO host_info (hostname, cpu_number,cpu_architecture,cpu_model,cpu_mhz,L2_cache,total_mem, timestamp)
VALUES ('$hostname', '$cpu_number', '$cpu_architecture', '$cpu_model', '$cpu_mhz', '$L2_cache', '$total_mem', '$timestamp');"

# execute the INSERT statement through the psql CLI tool
export PGPASSWORD=$psql_password
psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit 0