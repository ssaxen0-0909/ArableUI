package support;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HTMLReport {
    private static final String[] ROLES = {"member", "orgAdmin", "orgReader", "sysReader", "teamAdmin"};

    private static List<String> pageNames = new ArrayList<>();
    private static Map<String, Map<String, String>> pageData = new HashMap<>();

    public static void addPageName(String pageName) {
        if (!pageNames.contains(pageName)) {
            pageNames.add(pageName);
        }
    }

    public static void generateReport(String pageName, String loadInSeconds, double responseTimeInSeconds, String role) {
        Map<String, String> roleData = pageData.computeIfAbsent(pageName, k -> new HashMap<>());

        if (loadInSeconds == null || loadInSeconds.isEmpty()) {
            // Test case failed, mark as "Failed" for the specific role
            roleData.put(role, "Failed");
        } else {
            // Test case passed, update loadInSeconds and responseTimeInSeconds for the specific role
            try {
                double loadTime = Double.parseDouble(loadInSeconds);
                roleData.put(role, loadInSeconds + "s (" + responseTimeInSeconds + "s)");
            } catch (NumberFormatException e) {
                roleData.put(role, "NA");
            }
        }
    }

    public static void writeReportToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("response_time_report.html"));

            // Write the HTML header
            writer.write("<html>\n<head>\n<title>Response Time Report</title>\n</head>\n<body>\n");

            // Create the table structure
            writer.write("<table border=\"1\">\n");

            // Write the table header row for role names
            writer.write("<tr>\n");
            writer.write("<th>Page Name</th>\n");
            for (String role : ROLES) {
                writer.write("<th>" + role + "</th>\n");
            }
            writer.write("</tr>\n");

            // Write the table rows for page names and response times
            for (String pageName : pageNames) {
                Map<String, String> roleData = pageData.get(pageName);

                writer.write("<tr>\n");
                writer.write("<td>" + pageName + "</td>\n");

                // Loop through the roles and write the response times
                for (String role : ROLES) {
                    writer.write("<td>");
                    String loadInSeconds = roleData != null ? roleData.get(role) : null;
                    if (loadInSeconds != null && !loadInSeconds.equals("Failed")) {
                        double time;
                        try {
                            time = Double.parseDouble(loadInSeconds);
                        } catch (NumberFormatException e) {
                            time = 0.0;
                        }
                        if (time > 5) {
                            writer.write("<span style=\"color:red\">" + loadInSeconds + "s</span>");
                        } else {
                            writer.write(loadInSeconds + "s");
                        }
                    } else {
                        writer.write("<span style=\"color:red\">Failed</span>");
                    }
                    writer.write("</td>\n");
                }

                writer.write("</tr>\n");
            }

            // Close the table and body tags
            writer.write("</table>\n</body>\n</html>");

            // Close the writer
            writer.close();

            System.out.println("Response time report generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

