#version 150
// vim: ft=glsl

in vec3 Position;

out vec4 vertexColor;
out vec2 fragCoord;

void main() {
    gl_Position = vec4(Position, 1.0);

    fragCoord = Position.xy;
    vertexColor = gl_Position;
}
