<#include "../macro-head.ftl">
<!DOCTYPE html>
<html>
<head>
<@head title="${symphonyLabel}">
    <meta name="description" content="${symDescriptionLabel}"/>
</@head>
    <link rel="stylesheet" href="${staticServePath}/css/index.css?${staticResourceVersion}" />
    <link rel="canonical" href="${servePath}">
</head>
<body class="index">
${HeaderBannerLabel}
<#include "../header.ftl">
<h1>lincc</h1>
<h2>${msg}</h2>
<#include "../footer.ftl">

</body>
</html>
