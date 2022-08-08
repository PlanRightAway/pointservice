package com.planit.pointservice.endpoint;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RestController;

import com.planit.journey_common.endpoint.PointOpsController;
import com.planit.journey_common.model.Point;

@RestController
public class PointOpsControllerImpl implements PointOpsController {

	Map<Point, Point> pointCompleteMap = Map.of(new Point(1.0, 1.0, null, null)// --->
			, new Point(1.0, 1.0, "S1", null)
			, new Point(2.0, 2.0, null, null)// --->
			, new Point(2.0, 2.0, "S2", null)
			, new Point(2.1, 2.1, null, null)// --->
			, new Point(2.1, 2.1, "S2.1", null)
			, new Point(3.0, 3.0, null, null)// --->
			, new Point(3.0, 3.0, "S3", null)
			, new Point(3.1, 3.1, null, null)// --->
			, new Point(3.1, 3.1, "S3.1", null)
			, new Point(4.0, 4.0, null, null)// --->
			, new Point(4.0, 4.0, "S4", null)
			, new Point(4.1, 4.1, null, null)// --->
			, new Point(4.1, 4.1, "S4.1", null)
			, new Point(5.0, 5.0, null, null)// --->
			, new Point(5.0, 5.0, "S5", null));

	@Override
	public List<Point> getPointsByStringMatch(String matchString) {
		return pointCompleteMap.values().stream().filter(p -> null != p.getName() && p.getName().contains(matchString))
				.collect(Collectors.toList());
	}

	@Override
	public Point getPointByName(String name) {
		return pointCompleteMap.values().stream().filter(p -> null != p.getName() && p.getName().equalsIgnoreCase(name))
				.findFirst().orElse(new Point(-1d, -1d, null, null));
	}

	@Override
	public Point getPointInfo(Point point) {
		return pointCompleteMap.get(point) == null ? point : pointCompleteMap.get(point);
	}

}
