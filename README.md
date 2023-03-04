## Netter
Netter makes it easy for you to invoke api calls  and listen for all the possible responses for any standard rest api call using retrofit.Netter allows you to handle successful responses (2xx response codes, non empty response bodies)
,Server errors codes (non 2xx status code) and connectivity errors (a request that didn't result in a response). You don't have to explicitly  design and build wrapper classes such as `Resource` or `Result`,you just wrap your expected response in the `ApiCallResult<Pojo>` and you are set.
