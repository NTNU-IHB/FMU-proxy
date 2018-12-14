function [ response ] = remote( host, port, function_name, params )
%REMOTE Summary of this function goes here
%   Detailed explanation goes here

data = struct;
data.jsonrpc = "2.0";
data.method = function_name;
data.params = params;
data.id = '-';

data = java.lang.String(jsonencode(data));

url = java.net.URL("http://" + host + ":" + port + "/jsonrpc");
con = url.openConnection();
con.setRequestProperty("Content-Type", "application/json-rpc");
con.setRequestMethod("POST");
con.setDoOutput(true);

out = con.getOutputStream();
out.write(data.getBytes())
out.flush();
out.close();

con.connect();

reader = java.io.BufferedReader(java.io.InputStreamReader(con.getInputStream()));
sb = java.lang.StringBuilder();
read = reader.readLine();
while read~=0
    sb.append(read);
    read = reader.readLine();
end
reader.close();

read = char(sb.toString());
response = jsondecode(read);
response = response.result;

end

