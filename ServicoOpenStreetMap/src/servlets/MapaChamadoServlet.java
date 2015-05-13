package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MapaChamadoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		double lat = -8.0372619;
		double lng = -34.8713684;
		int zoom = 13;
		
		boolean showMarker = false;
		
		if (req.getParameter("lat") != null && req.getParameter("lng") != null) {
			try {
				lat = Double.parseDouble(req.getParameter("lat"));
				lng = Double.parseDouble(req.getParameter("lng"));
				
				zoom = 17;
				showMarker = true;
			} finally{}
		}

		
		resp.getWriter().write("<html><body>");
		resp.getWriter().write("<div id=\"mapdiv\" style=\"width:500px;height:380px;\"></div>");
		resp.getWriter().write("<script src=\"http://www.openlayers.org/api/OpenLayers.js\"></script>");
		resp.getWriter().write("<script>");  
		resp.getWriter().write("map = new OpenLayers.Map(\"mapdiv\");");  
		resp.getWriter().write("map.addLayer(new OpenLayers.Layer.OSM());");  
		resp.getWriter().write("var lonLat = new OpenLayers.LonLat(" + lng + "," + lat + ").transform(new OpenLayers.Projection(\"EPSG:4326\"), map.getProjectionObject());");
		resp.getWriter().write("var zoom=16;");    
		resp.getWriter().write("var markers = new OpenLayers.Layer.Markers( \"Markers\" );");
		resp.getWriter().write("map.addLayer(markers);");
		
		if (showMarker) {
			resp.getWriter().write("markers.addMarker(new OpenLayers.Marker(lonLat));");
		} 
		      
		resp.getWriter().write("map.setCenter (lonLat, zoom);");        
		resp.getWriter().write("</script>");          
		resp.getWriter().write("</body></html>");        
		
		
		
	}
}
