double angleClock(int hour, int minutes) {
    double hourAngle = hour * 30 + minutes * 0.5;
    int minuteAngle = minutes * 6;
    double angle1 = hourAngle - minuteAngle;
    angle1 = (angle1 < 0 ? -angle1 : angle1);
    double angle2 = 360 - angle1;
    return (angle1 < angle2 ? angle1 : angle2);
}